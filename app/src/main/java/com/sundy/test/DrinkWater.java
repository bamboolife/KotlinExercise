package com.sundy.test;

import android.util.Log;

import com.sundy.test.interfaces.Drink;

/**
 * 项目名称：KotlinExercise
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-04 11:27
 * 描述：
 */
public class DrinkWater implements Drink {
    @Override
    public void eatSomth() {
        Log.e("tag","native eat DrinkWater");
    }
}
