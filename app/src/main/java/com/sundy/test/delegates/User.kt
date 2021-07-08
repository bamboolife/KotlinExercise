package com.sundy.test.delegates

import kotlin.properties.Delegates

/**
 * 项目名称：KotlinDemo
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2021/6/28 12:12 AM
 * 描述：在赋值的时候会回调
 */
class User(private val map:Map<String,Any?>) {
    val name:String by map
    val age:Int by map


    var nameNot: String by Delegates.observable("name") {//可观察属性:监听器会收到有关此属性变更的通知
            prop, old, new ->
            println("$old->$new")
    }

    val lazyValue :String by lazy {//延迟属性;其值只在首次访问时计算
        println("computed")
        "Hello"
    }
}