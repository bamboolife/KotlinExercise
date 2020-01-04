package com.sundy.test.delegates;

import android.util.Log;

import com.sundy.test.EatBreckfast;
import com.sundy.test.interfaces.Eat;

/**
 * 项目名称：KotlinExercise
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-04 10:58
 * 描述：
 */
public class ConstantProxy implements Eat {
    private static final String TAG = ConstantProxy.class.getSimpleName();
    EatBreckfast eatBreckfast;

    public ConstantProxy(EatBreckfast eatBreckfast) {
        this.eatBreckfast = eatBreckfast;
    }

    @Override
    public void eatSomth() {
/***
 * 调用前想执行的动作

 */
        Log.e(TAG, "eat begin");
        eatBreckfast.eatSomth();
        /***

         *  调用后想执行的动作

         */
    }
}
