package com.sundy.test

import android.util.Log
import com.sundy.test.interfaces.Wash

/**
 *项目名称：KotlinExercise
 *@Author bamboolife
 *邮箱：core_it@163.com
 *创建时间：2020-01-04 11:50
 *描述：
 */
class WeshFood:Wash {
    override fun washSomth() {
        Log.e("tag","WeshFood........")
    }

    override fun testFun2(arg1: String, arg2: List<String>) {
        Log.e("tag","WeshFood........testFun2")
    }
}