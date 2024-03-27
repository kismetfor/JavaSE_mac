Tread的5种写法

1. 继承Thread 重写Run方法

   ![image-20240327131625618](/Users/rain/Library/Application Support/typora-user-images/image-20240327131625618.png)

2. 实现Runnable接口创建线程

   作用: 解耦合

   ![image-20240327132449719](/Users/rain/Library/Application Support/typora-user-images/image-20240327132449719.png)

   

   

3. 使用匿名内部类

   只能创建这一个实例

   实例创建完以后 就再也拿不到这个匿名内部类了

   ![image-20240327132751552](/Users/rain/Library/Application Support/typora-user-images/image-20240327132751552.png)

4. 使用lambda表达式

5. 使用线程池

   线程池是一种管理和复用线程的机制，它可以有效地管理大量的线程，避免频繁创建和销毁线程所带来的开销，并且可以控制并发线程数量，防止系统资源被过度消耗。Java 提供了 `Executor` 框架来支持线程池的使用。

   ![image-20240327133407879](/Users/rain/Library/Application Support/typora-user-images/image-20240327133407879.png)



