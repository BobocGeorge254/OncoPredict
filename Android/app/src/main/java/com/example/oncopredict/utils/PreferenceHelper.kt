package com.example.oncopredict.utils

import android.content.Context

object PreferenceHelper {
    private const val PREFS_NAME = "OncoPrefs"
    private const val KEY_AGE = "age"

    fun saveAge(context: Context, age: Int) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putInt(KEY_AGE, age).apply()
    }

    fun getAge(context: Context): Int {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getInt(KEY_AGE, -1)
    }

    fun clearAge(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().remove(KEY_AGE).apply()
    }
}
