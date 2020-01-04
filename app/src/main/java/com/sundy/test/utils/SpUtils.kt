package com.sundy.test.utils

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *项目名称：KotlinExercise
 *@Author bamboolife
 *邮箱：core_it@163.com
 *创建时间：2020-01-03 20:18
 *描述：
 */
class SpUtils<T>(val context: Context, val name: String, val default: T) :
    ReadWriteProperty<Any?, T> {
    val prefs by lazy {
        context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
         putPreference(name,value)
    }

    private fun <T> findPreference(name: String, default: T): T = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> this!!.getString(name, default)!!
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)

            else -> throw IllegalArgumentException(
                "This type can be saved into Preferences"
            )
        }
        res as T
    }

    private fun <U> putPreference(name: String, value: U) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }.apply()
    }
}