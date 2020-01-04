package com.sundy.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sundy.test.delegates.DelegatesExt
import com.sundy.test.delegates.DynamicProxy
import com.sundy.test.delegates.KotlinDynamicProxy
import com.sundy.test.delegates.KotlinProxy
import com.sundy.test.interfaces.Drink
import com.sundy.test.interfaces.Eat
import com.sundy.test.interfaces.Wash

class MainActivity : AppCompatActivity() {
    var earbreckFast: EatBreckfast? = null;
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

        var test1=KotlinDynamicProxy(washDish)
        var wash:Wash=test1.getProxy() as Wash
        wash.washSomth()
    }
}
