package com.example.dopame.data.repository

import com.example.dopame.data.model.MiningData
import com.example.dopame.network.adapter.ApiResult
import com.example.dopame.network.service.MiningService
import javax.inject.Inject

class MiningRepositoryImpl @Inject constructor(
    private val service: MiningService
): MiningRepository {
    override suspend fun getMiningList(): ApiResult<MiningData> {
        return service.getMiningList()
    }

}