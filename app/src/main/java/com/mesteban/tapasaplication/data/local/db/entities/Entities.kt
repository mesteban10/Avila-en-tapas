package com.mesteban.tapasaplication.data.local.db.entities

import androidx.room.*
import com.mesteban.aad_playground.ut03.ex06.domain.BarModel
import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel

@Entity(tableName = "tapas")
data class TapaEntity(
    @PrimaryKey @ColumnInfo(name = "id") val tapaId: String,
    val name: String,
    val description: String,
    val price: Double,
    val url: String
) {
    fun toModel(barEntity: BarEntity) = TapaModel(
        tapaId,
        name,
        description,
        price,
        url,
        barEntity.toDomain()
    )

    companion object {
        fun toEntity(tapaModel: TapaModel) = TapaEntity(
            tapaModel.id,
            tapaModel.name,
            tapaModel.description,
            tapaModel.price,
            tapaModel.urlMainPhoto
        )
    }
}

@Entity(tableName = "bar")
data class BarEntity(
    @PrimaryKey @ColumnInfo(name = "id") val barId: String,
    val name: String,
    val adress: String,
    @ColumnInfo(name = "tapa_id") val tapaId: String
) {
    fun toDomain() = BarModel(barId, name, adress)

    companion object {
        fun toEntity(tapaId: String, barModel: BarModel) =
            BarEntity(barModel.id, barModel.name, barModel.address, tapaId)
    }
}

data class TapaAndBar(
    @Embedded val tapaEntity: TapaEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "tapa_id"
    ) val barEntities: BarEntity,
) {
    fun toModel() = tapaEntity.toModel(barEntities)
}