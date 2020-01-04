package com.sundy.test;

import android.util.Log;

import com.sundy.test.interfaces.Eat;

/**
 * 项目名称：KotlinExercise
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-04 10:48
 * 描述：
 */
public class EatBreckfast implements Eat {
    @Override
    public void eatSomth() {
        Log.e("tag","native eat EatBreckfast");
    }
}
