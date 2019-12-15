package com.template.ultimaterepository.data.shared

import android.content.Context
import android.content.SharedPreferences

class SharedPrefImpl(context: Context) : SharedPref {

    companion object {
        private const val FILE_NAME = "ultimate_repo"
        private const val MODE = 0
        private const val K_IS_NOT_FIRST_TIME = "K_IS_NOT_FIRST_TIME"
    }


    private val sharedPref: SharedPreferences = context.getSharedPreferences(FILE_NAME, MODE)



    override fun isNotFirstTime(): Boolean {
        return sharedPref.getBoolean(K_IS_NOT_FIRST_TIME, false)
    }

    override fun setIsNotFirstTime(condition: Boolean) {
        sharedPref.edit().putBoolean(K_IS_NOT_FIRST_TIME,condition).apply()
    }


}

