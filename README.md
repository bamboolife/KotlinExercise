# Kotlin学习笔记

### Kotlin 笔记 : !!. 与 ?. 的区别

?.

```
//kotlin:
a?.run()
 
//与java相同:
if(a!=null){
 a.run();
}
```
!!.

```
//kotlin:
a!!.run()
 
//与java相同: 
if(a!=null){
 a.run();
}else{
 throw new KotlinNullPointException();
}
```
> 说明?. 与 !!. 都是Kotlin提供的检测空指针的方法

### @JvmOverloads 注解
> 含义：方法的重载
```java
 @JvmOverloads fun setUser(name:String,age:Int=0,sex:String="男"){

    }
 //相当于java中的
 void setUser(String name)
 void setUser(String name,int age)
 void setUser(String name,int age,String sex)
```
> 构造函数重载
```java
class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
}

//相当于java
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
```
### @JvmField （定义常量方式一）
- 在val常量前面增加一个@JvmField就可以将它变成常量。
- 其内部作用是抑制编译器生成相应的getter方法
- 是用该注解修饰后则无法重写val的get方法
```java
 @JvmField val NAME = "89757
```
