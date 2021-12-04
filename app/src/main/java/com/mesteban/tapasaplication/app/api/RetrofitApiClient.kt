package com.mesteban.tapasaplication.app.api

import com.mesteban.aad_playground.ut03.ex06.domain.Failure
import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.concurrent.TimeUnit

class RetrofitApiClient : ApiClient {

    private val urlEndPoint: String = ""
    private var apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): ApiEndPoint {
        return build().create(ApiEndPoint::class.java)
    }


    private fun build(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .client(buildHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()


    override suspend fun fetchTapas(): Result<List<TapaModel>> = withContext(Dispatchers.IO){
        return@withContext try {
            apiEndPoint.fetchTapas().mapCatching {
                if (it.isSuccessful) {
                    it.body()?.data ?: mutableListOf()
                } else {
                    mutableListOf()
                }
            }
        }catch (failure: Exception){
            Result.failure(Failure.ApiError)
        }
    }

    override suspend fun fetchTapa(tapaId: String): Result<TapaModel?> = withContext(Dispatchers.IO) {
        return@withContext try {
            apiEndPoint.fetchTapa(tapaId).mapCatching {
                if (it.isSuccessful) {
                    it.body()?.data
                } else {
                    null
                }
            }
        }catch (failure: Exception){
            Result.failure(Failure.ApiError)
        }

    }
}