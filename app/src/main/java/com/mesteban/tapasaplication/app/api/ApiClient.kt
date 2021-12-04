package com.mesteban.tapasaplication.app.api

import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel

interface ApiClient {
    suspend fun fetchTapas(): Result<List<TapaModel>>
    suspend fun fetchTapa(tapaId: String): Result<TapaModel?>
}