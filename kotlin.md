https://blog.csdn.net/u013064109/article/details/78786646

> 简述:
相比Java, Kotlin提供了不少高级语法特性。对于一个Kotlin的初学者来说经常会写出一些不够优雅的代码。
在Kotlin中的源码标准库(Standard.kt)中提供了一些Kotlin扩展的内置函数可以优化kotlin的编码。Standard.kt
是Kotlin库的一部分，它定义了一些基本函数。 这个源代码文件虽然代码不多，但是这些函数功能都非常强大。

## 一、回调函数的Kotin的lambda的简化

在Kotlin中对Java中的一些的接口的回调做了一些优化，可以使用一个lambda函数来代替。可以简化写一些不必要的嵌套回调方法。但是需要注意:在lambda表达式，只支持单抽象方法模型，也就是说设计的接口里面只有一个抽象的方法，才符合lambda表达式的规则，多个回调方法不支持。

- 1、用Java代码实现一个接口的回调。
```java
 mView.setEventListener(new ExamPlanHomeEventListener(){
 
    public void onSuccess(Data data){
      //todo
    }
 
 });
```
- 2、在Kotlin中的实现一个接口的回调,不使用lambda表达式(这种方式非常适用于kotlin中对于一个接口中含有多个回调方法)。

```java
mView.setEventListener(object: ExamPlanHomeEventListener{
     
    public void onSuccess(Data data){
      //todo
    }
     
});
```
- 3、如果在Kotlin中的对于接口只有一个回调的方法，就符合使用lambda函数，我们可以把以上代码简化成这样。
```java
mView.setEventListener({
   data: Data ->
   //todo
})

//或者可以直接省略Data,借助kotlin的智能类型推导

mView.setEventListener({
   data ->
   //todo
})
```
- 4、如果以上代码中的data参数没有使用到的话，可以直接把data去掉
```java
mView.setEventListener({
  //todo

})
```
- 5、以上代码还可以做个调整，由于setEventListener函数最后一个参数是一个函数的话，可以直接把括号的实现提到圆括号外面
```java
mView.setEventListener(){
   //todo
}
```
- 6、由于setEventListener这个函数只有一个参数，可以直接省略圆括号
```java
mView.setEventListener{
  //todo
}
```

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
| apply	| fun T.apply(block: T.() -> Unit): T { block(); return this } |	this指代当前对象或者省略 |	返回this	 | 是 |	1、适用于run函数的任何场景，一般用于初始化一个对象实例的时候，操作对象属性，并最终返回这个对象。<br>2、动态inflate出一个XML的View的时候需要给View绑定数据也会用到.<br>3、一般可用于多个扩展函数链式调用<br>4、数据model多层级包裹判空处理的问题 |
| also	 | fun T.also(block: (T) -> Unit): T { block(this); return this }	| it指代当前对象 |	返回this	| 是 |	适用于let函数的任何场景，一般可用于多个扩展函数链式调用 |
