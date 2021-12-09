package com.mesteban.tapasaplication.app.storage

import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel

interface LocalStorage<T : TapaModel> {
    suspend fun fetchAll(model: T, typeClass: Class<T>): Result<List<T>>
    suspend fun fetch(modelId: String, typeClass: Class<T>) : Result<T?>
}