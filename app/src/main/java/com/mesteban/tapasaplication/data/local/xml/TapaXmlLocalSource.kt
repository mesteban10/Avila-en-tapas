package com.mesteban.tapasaplication.data.local.xml

import android.content.Context
import com.mesteban.aad_playground.commons.serializer.JsonSerializer
import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel
import com.mesteban.tapasaplication.data.local.LocalDataSource

class AlertXmlLocalSource(
    private val context: Context,
    private val serializer: JsonSerializer
) : LocalDataSource {

    private val nameXmlFile = "app_tapas"
    private val sharedPref = context.getSharedPreferences(nameXmlFile, Context.MODE_PRIVATE)


    override suspend fun fetchTapas(): Result<List<TapaModel>> {
        val tapas: MutableList<TapaModel> = mutableListOf()
        val jsonStrings = sharedPref.all.map { it.value }
        jsonStrings.map { jsonString ->
            serializer.fromJson(
                jsonString as String,
                TapaModel::class.java
            )
        }
        return tapas.toList()
    }


    override suspend fun fetchTapa(tapaId: String): Result<TapaModel?> {
        val jsonModel = sharedPref.getString(tapaId, null)
        return if (jsonModel != null ) {
            serializer.fromJson(jsonModel, TapaModel::class.java)
        } else {
            null
        }
    }
}
