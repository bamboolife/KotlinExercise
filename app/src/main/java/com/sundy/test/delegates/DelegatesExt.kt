package com.sundy.test.delegates

import android.content.Context

import com.sundy.test.utils.SpUtils

/**
 *项目名称：KotlinExercise
 *@Author bamboolife
 *邮箱：core_it@163.com
 *创建时间：2020-01-03 20:38
 *描述：
 */
object DelegatesExt {
    fun <T : Any> spUtils(context: Context, nane: String, default: T) =SpUtils(context, nane, default)
}