package demo2;
class Tire{
//    轮胎类

}


class Engine{
    //发动机类
}

class VehicleSystem{
    //车载系统类

}
class Car {
    private Tire tire; //可以复用轮胎中的属性和方法
    private Engine engine;//可以复用发动机中的属性和方法
    private VehicleSystem vs; //可以复用车载系统中的属性和方法
    //...
}
//奔驰是汽车
class Benz extends Car{
    //将汽车中包含的:轮胎、发送机、车载系统全部继承下来
}

public class Test {

}
//组合是一种思想