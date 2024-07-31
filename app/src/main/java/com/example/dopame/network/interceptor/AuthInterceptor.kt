package com.example.dopame.network.interceptor

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.dopame.core.util.Constants.ACCESS_TOKEN
import com.example.dopame.core.util.Constants.REFRESH_TOKEN
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val datastore: DataStore<Preferences>
) {
    fun getAccessToken(): Flow<String?> {
        return datastore.data.map { prefs ->
            prefs[ACCESS_TOKEN]
        }
    }

    fun getRefreshToken(): Flow<String?> {
        return datastore.data.map { prefs ->
            prefs[REFRESH_TOKEN]
        }
    }


}