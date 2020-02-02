package com.sundy.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.sundy.test.bean.Constant
import com.sundy.test.bean.PensonBean
import com.sundy.test.delegates.DelegatesExt
import com.sundy.test.delegates.DynamicProxy
import com.sundy.test.delegates.KotlinDynamicProxy
import com.sundy.test.delegates.KotlinProxy
import com.sundy.test.interfaces.Drink
import com.sundy.test.interfaces.Eat
import com.sundy.test.interfaces.Wash
import com.sundy.test.utils.Singleton

class MainActivity : AppCompatActivity() {
    val recyclerView:RecyclerView?=null
    var earbreckFast: EatBreckfast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var age: Int by DelegatesExt.spUtils(this, "age", 11)
        earbreckFast = EatBreckfast()

        var dynamicProxy = DynamicProxy(earbreckFast)
        var eat: Eat = dynamicProxy.proxy as Eat
        eat.eatSomth()

        var drinkWater: DrinkWater = DrinkWater()
        var dynamicProxyDirnk = DynamicProxy(drinkWater)
        var drink: Drink = dynamicProxyDirnk.proxy as Drink

        drink.eatSomth()

        var washDish = WashDish()
        var dish = KotlinProxy(washDish)
        dish.washSomth()

        var weshFood=WeshFood()
        var proxy=KotlinProxy(weshFood)
        proxy.washSomth()

        val  result="testLst".let {
           // println(it.length)
            1000
            "我的一个测试"
        }
        println(result)
        Singleton.instance?.getUser()
    }
}
