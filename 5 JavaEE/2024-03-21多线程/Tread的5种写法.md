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

5. 匿名内部类

   ![image-20240327153515897](/Users/rain/Library/Application Support/typora-user-images/image-20240327153515897.png)

6. 匿名内部类--针对Runnable

![image-20240327155543346](/Users/rain/Library/Application Support/typora-user-images/image-20240327155543346.png)

