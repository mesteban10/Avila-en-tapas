package com.mesteban.tapasaplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TapaActivity : AppCompatActivity() {

    private val TAG = TapaActivity::class.java.simpleName

    val viewModel = Ut03Ex06ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex06)
        init()
    }

    private fun init() {
        loadTapas()
        loadTapa()
    }

    private fun loadTapas() {
        Thread {
            renderUiTapas(viewModel.loadTapas())
        }.start()
    }

    private fun loadTapa() {
        Thread {
            renderUiTapa(viewModel.loadTapa("123"))
        }.start()
    }

    private fun renderUiTapas(tapasViewState: TapasViewState) {
        tapasViewState.tapaModels?.let {
            Log.d(TAG, "Tapas: $it")
        }
        tapasViewState.failure?.let {
            Log.d(TAG, "Error: $it")
        }
    }

    private fun renderUiTapa(tapaViewState: TapaViewState) {
        tapaViewState.tapaModels?.let {
            Log.d(TAG, "Tapas: $it")
        }
        tapaViewState.failure?.let {
            Log.d(TAG, "Error: $it")
        }
    }
}