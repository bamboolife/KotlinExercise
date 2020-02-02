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
> 含义：方法的重载，类似于在java中对多个构造函数、多个方法的重载
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
