package com.mesteban.tapasaplication.data.local.xml

import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel
import com.mesteban.tapasaplication.app.storage.LocalModel

class TapasLocalModel(
    val index: String,
    val alerts: List<TapaModel>
) : LocalModel {
    override fun getId(): String = index

    companion object {
        val ID: String = TapasLocalModel::class.java.simpleName
    }
}