package com.sundy.test.delegates

import android.util.Log
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 *项目名称：KotlinExercise
 *@Author bamboolife
 *邮箱：core_it@163.com
 *创建时间：2020-01-04 14:27
 *描述：
 */
class KotlinDynamicProxy(target: Any) :InvocationHandler {
    var target:Any?=null
    init {
        this.target=target
    }
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {

        args?.let {
            for (any in it){
                Log.i("angcyo", "参数类型:" + any.javaClass.simpleName)
            }
        }
        var obj= method?.invoke(target,args)

        return obj
    }

    fun getProxy():Any{
       return Proxy.newProxyInstance(target?.javaClass?.classLoader,target?.javaClass?.interfaces,this)
    }
}