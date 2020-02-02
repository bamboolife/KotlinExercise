package com.sundy.test.bean

/**
 * 项目名称：KotlinExercise
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-02-02 19:59
 * 描述：
 */
class UserBean {
    var name: String
    var age = 0
    var sex: String? = null

    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    constructor(name: String, age: Int, sex: String?) {
        this.name = name
        this.age = age
        this.sex = sex
    }

}