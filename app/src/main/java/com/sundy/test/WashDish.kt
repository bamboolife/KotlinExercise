package com.sundy.test

import android.util.Log
import com.sundy.test.interfaces.Wash

/**
 *项目名称：KotlinExercise
 *@Author bamboolife
 *邮箱：core_it@163.com
 *创建时间：2020-01-04 11:43
 *描述：
 */
open class WashDish : Wash {
    override fun washSomth() {
        Log.e("tag","washSomth.......")
    }

    override fun testFun2(arg1: String, arg2: List<String>) {
        Log.e("tag","testFun2.......")
    }
}