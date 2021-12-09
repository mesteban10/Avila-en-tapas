package com.mesteban.tapasaplication.data.local.files

import android.content.Context
import com.mesteban.aad_playground.commons.serializer.JsonSerializer
import com.mesteban.aad_playground.ut03.ex06.domain.Failure
import com.mesteban.aad_playground.ut03.ex06.domain.TapaModel
import com.mesteban.tapasaplication.data.local.LocalDataSource
import java.io.File

class TapaFileLocalSource(
    private val context: Context,
    private val serializer: JsonSerializer
) : LocalDataSource {

    private lateinit var tapaFile: File

    private fun buildFile() {
        tapaFile = File(context.filesDir, TAPAS_FILENAME)
        if (!tapaFile.exists()) {
            tapaFile.createNewFile()
        }
    }

    override suspend fun fetchTapas(): Result<List<TapaModel>> {
        return try {
            getFile().mapCatching {
                val tapas: MutableList<TapaModel> = mutableListOf()
                val lines = it.readLines()
                lines.map { line ->
                    val tapaModel = serializer.fromJson(line, TapaModel::class.java)
                    tapas.add(tapaModel)
                }
                tapas
            }
        } catch (failure: Exception) {
            Result.failure(Failure.FileError)
        }
    }

    override suspend fun fetchTapa(tapaId: String): Result<TapaModel?> {
        return fetchTapas().mapCatching { it.firstOrNull { item -> item.id == tapaId } }
    }

    private fun getFile(): Result<File> {
        return try {
            if (!this::tapaFile.isInitialized) {
                buildFile()
            }
            Result.success(tapaFile)
        } catch (ex: Exception) {
            Result.failure(Failure.FileError)
        }
    }

    companion object {
        const val TAPAS_FILENAME: String = "aad_tapas.txt"
        fun getTapasDetailFileName(tapaId: String): String = "aad_tapa_detail_$tapaId.txt"
    }


}
