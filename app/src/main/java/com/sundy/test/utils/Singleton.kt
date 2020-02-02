package com.sundy.test.utils

/**
 * 项目名称：KotlinExercise
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-02-02 20:50
 * 描述：
 */
object Singleton {
    var instance: Singleton? = null

        get() {
            if (field == null) {
                synchronized(Singleton::class.java) {
                    if (field == null) {
                        field = Singleton
                    }
                }
            }
            return field
        }
        private set

    fun getUser(){

    }
}