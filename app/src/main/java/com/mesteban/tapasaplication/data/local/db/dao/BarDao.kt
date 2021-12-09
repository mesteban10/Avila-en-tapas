package com.mesteban.tapasaplication.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.mesteban.tapasaplication.data.local.db.entities.BarEntity

@Dao
interface BarDao {
    @Insert
    fun insert(barEntitie: BarEntity)
}