package com.mesteban.tapasaplication.app.storage

import android.content.Context
import com.mesteban.aad_playground.commons.serializer.JsonSerializer
import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class SharPrefLocalStorage<T : LocalModel>(
    private val context: Context,
    private val jsonSerializer: JsonSerializer,
    private val nameXmlFile: String
) : LocalStorage<TapaModel> {

    private val sharedPref = context.getSharedPreferences(nameXmlFile, Context.MODE_PRIVATE)




override suspend fun fetch(modelId: String, typeClass: Class<TapaModel>): Result<TapaModel?> = withContext(Dispatchers.IO) {
    val jsonModel = sharedPref.getString(modelId, "")
    return@withContext jsonModel.runCatching {
        if (jsonModel != null) {
            jsonSerializer.fromJson(jsonModel, typeClass)
        } else {
            null
        }
    }
}

    override suspend fun fetchAll(
        model: TapaModel,
        typeClass: Class<TapaModel>
    ): Result<List<TapaModel>> {
        TODO("Not yet implemented")
    }


}