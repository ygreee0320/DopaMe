package com.example.dopame.network.interceptor

import androidx.datastore.core.DataStore
import com.example.dopame.core.util.Constants.ACCESS_TOKEN
import com.example.dopame.core.util.Constants.REFRESH_TOKEN
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TokenManager @Inject constructor(
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