### 常量

Java中：
```java
   class StaticDemoActivity {
         public static final String LOAN_TYPE = "loanType";
         public static final String LOAN_TITLE = "loanTitle";
    }
```

Kotlin中：

```kotlin
  class StaticDemoActivity {
      companion object {
           val  LOAN_TYPE = "loanType"
           val  LOAN_TITLE = "loanTitle"
    }
}

或者

  class StaticDemoActivity {
      companion object StaticParams{
            val  LOAN_TYPE = "loanType"
            val  LOAN_TITLE = "loanTitle"
    }
}

 或者
  class StaticDemoActivity {
      companion object {
         const val LOAN_TYPE = "loanType"
         const val LOAN_TITLE = "loanTitle"
    }
}
```
> 注：const 关键字用来修饰常量，且只能修饰 val，不能修饰var, companion object 的名字可以省略，可以使用 Companion来指代

### 引用常量（这里的引用只针对于java引用kotlin代码）

TestEntity类引用StaticDemoActivity中的常量

```java
   class TestEntity {
        public TestEntity () {
            String title = StaticDemoActivity.Companion.getLOAN_TITLE();
    }
  }

  或者

  class TestEntity {
        public TestEntity () {
            String title = StaticDemoActivity.StaticParams.getLOAN_TITLE();
        }
  }

  或者

  class TestEntity {
        public TestEntity () {
            String title = StaticDemoActivity.LOAN_TITLE;
            String type= StaticDemoActivity.LOAN_TYPE;
        }
  }
```
### 静态方法

Java代码：
```java
      class StaticDemoActivity {
          public static void test(){
                、、、
          }
      }
```

Kotlin中：

```java
      class StaticDemoActivity {
          companion object {
               fun test(){
                    、、、
                }
          }
      }

  或者

       class StaticDemoActivity {
          companion object StaticParams{
              fun test() {
                  、、、
              }
          }
      }
```

### 引用静态方法（这里的引用只针对于java引用kotlin代码）
```java
TestEntity类引用StaticDemoActivity中的静态方法

    class TestEntity {
          public TestEntity () {
                StaticDemoActivity.Companion.test();
          }
    }

或者

    class TestEntity {
          public TestEntity () {
             StaticDemoActivity.StaticParams.test();
          }
    }
 ```
> companion object {}中用来修饰 静态常量，或者静态方法，单例等等


### object关键字

object 关键字可以表达两种含义：一种是对象表达式,另一种是 对象声明。

#### 1、对象表达式

继承一个匿名对象

```java
val textView = findViewById<TextView>(R.id.tv)
textView.setOnClickListener(object : OnClickListener {
        override fun onClick(p0: View?) {
            Toast.makeText(this@TestActivity, "点击事件生效", Toast.LENGTH_LONG)
        }

})
```
上面代码其实就是我们经常要给 view 设置的点击事件，OnClickListener 事件是一个匿名类的对象，用object来修饰。

#### 2、对象声明
用object 修饰的类为静态类，里面的方法和变量都为静态的。

##### 2.1 直接声明类
```java
object DemoManager {
    private val TAG = "DemoManager"

    fun a() {
        Log.e(TAG,"此时 object 表示 声明静态内部类")
    }

}
```
##### 2.2 声明静态内部类

类内部的对象声明，没有被inner 修饰的内部类都是静态的
```java
class DemoManager{
    object MyObject {
        fun a() {
            Log.e(TAG,"此时 object 表示 直接声明类")
        }
    }
}
```
如果需要调用 a()方法

kotlin中调用
```java
fun init() {
    MyObject.a()
}
```
java中调用
```java
 MyObject.INSTANCE.a();
 ```


