package com.example.dopame.domain.usecase

import com.example.dopame.data.model.MiningData
import com.example.dopame.screens.existingMining.MiningRepository
import javax.inject.Inject

class GetMiningListUseCase @Inject constructor(
    private val miningRepository: MiningRepository
) {
    suspend operator fun invoke(): List<MiningData> {
        return miningRepository.getAllData()
    }
}