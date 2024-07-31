package com.example.dopame.core.util

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {
    const val DopaMe_DATASTORE = "DopaMe_datastore"

    //preferencekeys
    val ACCESS_TOKEN = stringPreferencesKey("access_token")
    val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
    val USER_ID = intPreferencesKey("user_id")
}