package com.mesteban.tapasaplication.data.local.db

import android.content.Context
import com.mesteban.aad_playground.ut03.ex06.domain.Failure
import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel
import com.mesteban.tapasaplication.app.db.TapaDatabase
import com.mesteban.tapasaplication.data.local.LocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TapaDbLocalSource(private val appContext: Context) : LocalDataSource {

    private val db = TapaDatabase.getInstance(appContext)


    override suspend fun fetchTapas(): Result<List<TapaModel>> = withContext(Dispatchers.IO) {
        val dbTapas = db.tapaDao().findAll()
        return@withContext try {
            dbTapas.runCatching { tapaEntity -> tapaEntity.toModel() }

        }catch (failure: Exception) {
            Result.failure(Failure.FileError)
        }

    }


    override suspend fun fetchTapa(tapaId: String): TapaModel? = withContext(Dispatchers.IO) {
        val tapaEntity = db.tapaDao().findById(tapaId)
        tapaEntity?.toModel()
    }
}