package com.mesteban.tapasaplication.data.local

import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel

interface LocalDataSource {
    suspend fun fetchTapas(): Result<List<TapaModel>>
    suspend fun fetchTapa(tapaId: String): Result<TapaModel?>
}