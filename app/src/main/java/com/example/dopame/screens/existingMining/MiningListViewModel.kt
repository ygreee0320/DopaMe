package com.example.dopame.screens.existingMining

import com.example.dopame.core.base.BaseViewModel
import com.example.dopame.domain.usecase.GetMiningListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MiningListViewModel @Inject constructor(
    private val getMiningListUseCase: GetMiningListUseCase
) : BaseViewModel<MiningContract.Event, MiningContract.State, MiningContract.Effect>(
    initialState = MiningContract.State()
) {
    override fun reduceState(event: MiningContract.Event) {
        when(event) {

            else -> {}
        }
    }

}