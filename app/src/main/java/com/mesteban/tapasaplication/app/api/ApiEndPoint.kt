package com.mesteban.tapasaplication.app.api

import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiEndPoint {
    @GET("tapas")
    suspend fun fetchTapas(): Result<Response<ApiResponse<List<TapaModel>>>>

    @GET("tapas/{tapa_id}")
    suspend fun fetchTapa(@Path("tapa_id") alertId: String): Result<Response<ApiResponse<TapaModel>>>
}
