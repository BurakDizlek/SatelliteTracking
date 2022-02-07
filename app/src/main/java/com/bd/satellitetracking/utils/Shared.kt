package com.bd.satellitetracking.utils

import android.content.Context
import android.content.SharedPreferences

class Shared(context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    fun put(key: String, value: String) {
        val prefEdit = sharedPref.edit()
        prefEdit?.putString(key, value)
        prefEdit?.apply()
    }

    fun getString(key: String, defaultValue: String): String {
        return try {
            sharedPref.getString(key, defaultValue) ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }
}