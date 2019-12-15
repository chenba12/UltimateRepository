package com.template.ultimaterepository.data.shared

interface SharedPref {

    fun isNotFirstTime():Boolean

    fun setIsNotFirstTime(condition:Boolean)
}