package com.example.dopame.screens.existingMining

import android.content.Context
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import com.example.dopame.core.base.UiEffect
import com.example.dopame.core.base.UiEvent
import com.example.dopame.core.base.UiState
import com.example.dopame.data.model.MiningData

class MiningContract {
    data class State (
        val miningData: List<MiningData> = emptyList(),
    ): UiState

    sealed class Event: UiEvent {
        data class showMiningDetail(val context: Context): Event()
    }

    sealed class Effect: UiEffect {
        data class NavigateTo(
            val destinaton: String,
            val navOptions: NavOptions? = null,
            val builder: NavOptionsBuilder.() -> Unit = {}
        ): MiningContract.Effect()
        data class Toastmessage(val message: String): Effect()
    }
}