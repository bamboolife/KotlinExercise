package com.sundy.test.delegates;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 项目名称：KotlinExercise
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-04 11:09
 * 描述：
 */
public class DynamicProxy implements InvocationHandler {

    private static final String TAG = DynamicProxy.class.getSimpleName();
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    /***
     *
     * 系统类的方法
     * 类初始化的时候
     * 被系统自动调用
     ****@param****proxy*
     ****@param****method*
     ****@param****args*
     ****@return*********@throws****Throwable*

     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//调用前想执行的动作
        Object result = method.invoke(target, args);
//调用后想执行的动作
        return result;
    }

    public Object getProxy() {
        return (Object) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
