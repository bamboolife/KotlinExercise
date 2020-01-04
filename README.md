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
