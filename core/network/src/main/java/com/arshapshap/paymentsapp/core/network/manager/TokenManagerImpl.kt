package com.arshapshap.paymentsapp.core.network.manager

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

private const val FILE_NAME = "payments_app_shared_prefs"
private const val TOKEN_SHARED_PREFS_KEY = "token"
internal class TokenManagerImpl(
    context: Context
) : TokenManager {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        FILE_NAME,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private val editor = sharedPreferences.edit()

    override fun getToken(): String? {
        return sharedPreferences.getString(TOKEN_SHARED_PREFS_KEY, null)
    }

    override fun saveToken(token: String) {
        editor.putString(TOKEN_SHARED_PREFS_KEY, token).apply()
    }
}