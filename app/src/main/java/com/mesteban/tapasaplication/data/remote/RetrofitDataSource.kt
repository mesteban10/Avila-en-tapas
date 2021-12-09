package com.mesteban.tapasaplication.data.remote

import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel
import com.mesteban.tapasaplication.app.api.ApiClient

class RetrofitDataSource(private val apiClient: ApiClient) : RemoteDataSource {
    override suspend fun getTapas(): Result<List<TapaModel>> {
        return apiClient.fetchTapas()
    }

    override suspend fun getTapa(tapaId: String): Result<TapaModel?> {
        return apiClient.fetchTapa(tapaId)
    }
}

