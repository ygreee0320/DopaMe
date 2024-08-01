package com.example.dopame.network.interceptor

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager,
    @ApplicationContext private val context: Context
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken = runBlocking { tokenManager.getAccessToken().first() } ?: ""
        val refreshToken = runBlocking { tokenManager.getRefreshToken().first() } ?: ""
        val originalRequest = chain.request()
        val authenticationRequest = accessToken?.let {
            originalRequest.newBuilder()
                .addHeader("AUTHORIZATION", "Bearer $accessToken")
                .build()
        }
        val response = authenticationRequest?.let { chain.proceed(it) }
        if(response?.code == 401 && refreshToken.isNotEmpty()) {
            val newToken = runBlocking {  }
            /*if(newToken is ApiResult.Success) {
                val newAccessToken = newToken.data.data.accessToken
                val refreshToken = newToken.data.data.refreshToken
                runBlocking {  }
                response.close()
                val newAuthenticationRequest = originalRequest.newBuilder()
                    .header(AUTHORIZATION, "Bearer $newAccessToken")
                    .build()
                return chain.proceed(newAuthenticationRequest)
            } else {
                //runBlocking { tokenManager.deleteAccessToken() }
            }*/
        }
        return response!!
    }


}