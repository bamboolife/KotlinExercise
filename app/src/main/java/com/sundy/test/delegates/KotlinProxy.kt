package com.sundy.test.delegates

import com.sundy.test.interfaces.Wash

/**
 *项目名称：KotlinExercise
 *@Author bamboolife
 *邮箱：core_it@163.com
 *创建时间：2020-01-04 11:45
 *描述：
 */
class KotlinProxy(wash: Wash):Wash by wash