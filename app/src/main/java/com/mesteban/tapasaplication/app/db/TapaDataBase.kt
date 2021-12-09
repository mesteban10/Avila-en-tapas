package com.mesteban.tapasaplication.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mesteban.tapasaplication.data.local.db.dao.TapaDao
import com.mesteban.tapasaplication.data.local.db.dao.BarDao
import com.mesteban.tapasaplication.data.local.db.entities.BarEntity
import com.mesteban.tapasaplication.data.local.db.entities.TapaEntity

@Database(
    entities = [TapaEntity::class, BarEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TapaDatabase : RoomDatabase() {

    abstract fun tapaDao(): TapaDao
    abstract fun barDao(): BarDao


    companion object {
        @Volatile
        private var instance: TapaDatabase? = null

        fun getInstance(applicationContext: Context): TapaDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): TapaDatabase {
            return Room.databaseBuilder(
                applicationContext,
                TapaDatabase::class.java,
                "db-tapas"
            ).build()
        }
    }
}