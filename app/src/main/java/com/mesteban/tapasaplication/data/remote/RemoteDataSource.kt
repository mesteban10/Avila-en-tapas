package com.mesteban.tapasaplication.data.remote

import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel


interface RemoteDataSource {
    suspend fun getTapas(): Result<List<TapaModel>>
    suspend fun getTapa(tapaId: String): Result<TapaModel?>
}