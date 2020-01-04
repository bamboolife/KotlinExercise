https://blog.csdn.net/u013064109/article/details/78786646

> 简述:
相比Java, Kotlin提供了不少高级语法特性。对于一个Kotlin的初学者来说经常会写出一些不够优雅的代码。
在Kotlin中的源码标准库(Standard.kt)中提供了一些Kotlin扩展的内置函数可以优化kotlin的编码。Standard.kt
是Kotlin库的一部分，它定义了一些基本函数。 这个源代码文件虽然代码不多，但是这些函数功能都非常强大。

## 一、回调函数的Kotin的lambda的简化

## 二、内联扩展函数之let

## 三、内联函数之with

## 四、内联扩展函数之run

## 五、内联扩展函数之apply

## 六、内联扩展函数之also

## 七、let,with,run,apply,also函数区别

| 函数名	| 定义inline的结构 |	函数体内使用的对象	 | 返回值 |	是否是扩展函数 |	适用的场景|
|:------ |:-------------- |:---------------- |:-------- |:--------- |:-----------|
| let |	fun <T, R> T.let(block: (T) -> R): R = block(this) |	it指代当前对象 |	闭包形式返回	| 是 |	适用于处理不为null的操作场景 |
| with |	fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block() |	this指代当前对象或者省略 |	闭包形式返回	| 否 |	适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，经常用于Android中RecyclerView中onBinderViewHolder中，数据model的属性映射到UI上 |
| run	| fun <T, R> T.run(block: T.() -> R): R = block()	| this指代当前对象或者省略 |	闭包形式返回 |	是 |	适用于let,with函数任何场景。|
| apply	| fun T.apply(block: T.() -> Unit): T { block(); return this } |	this指代当前对象或者省略 |	返回this	 | 是 |	1、适用于run函数的任何场景，一般用于初始化一个对象实例的时候，操作对象属性，并最终返回这个对象。
<br>2、动态inflate出一个XML的View的时候需要给View绑定数据也会用到.
<br>3、一般可用于多个扩展函数链式调用
<br>4、数据model多层级包裹判空处理的问题 |
| also	 | fun T.also(block: (T) -> Unit): T { block(this); return this }	| it指代当前对象 |	返回this	| 是 |	适用于let函数的任何场景，一般可用于多个扩展函数链式调用 |
