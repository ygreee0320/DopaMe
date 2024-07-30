package com.example.dopame.data.network.service

import com.example.dopame.data.model.MiningData
import com.example.dopame.data.network.adapter.ApiResult
import retrofit2.http.GET

interface MiningService {
    @GET("/member/minings")
    suspend fun getMiningList(

    ): ApiResult<MiningData>
}