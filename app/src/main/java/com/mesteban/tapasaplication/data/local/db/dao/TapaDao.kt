package com.mesteban.tapasaplication.data.local.db.dao

import androidx.room.*
import com.mesteban.tapasaplication.data.local.db.entities.TapaAndBar

@Dao
interface TapaDao {

    @Transaction
    @Query("SELECT * FROM tapas")
    fun findAll(): List<TapaAndBar>

    @Transaction
    @Query("SELECT * FROM tapas WHERE id = :tapaId")
    fun findById(tapaId: String): TapaAndBar?

}