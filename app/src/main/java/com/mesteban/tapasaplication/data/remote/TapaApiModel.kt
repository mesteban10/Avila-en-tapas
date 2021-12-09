package com.mesteban.tapasaplication.data.remote

import com.mesteban.aad_playground.ut03.ex06.domain.BarModel
import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel

data class TapaApiModel (
    val tapa_id: String,
    val name: String,
    val description: String,
    val price: String,
    val urlMainPhoto: String,
    val barModel: BarApiModel
        ){
    fun toDomainModel(): TapaModel = TapaModel(
        tapa_id,
        name,
        description,
        price.toDouble(),
        urlMainPhoto,
        barModel.toDomainModel()
    )
}

data class BarApiModel(val id: String, val name: String, val address: String) {
    fun toDomainModel() = BarModel(id, name, address)
}