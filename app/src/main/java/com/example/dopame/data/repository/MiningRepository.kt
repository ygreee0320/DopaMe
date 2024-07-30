package com.example.dopame.data.repository

import com.example.dopame.data.model.MiningData
import com.example.dopame.data.network.adapter.ApiResult

interface MiningRepository {
    suspend fun getMiningList(): ApiResult<MiningData>
}
