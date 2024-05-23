package com.bite.springioc.v1;

/**
 * 从代码来看，这段代码表现出了一些高耦合的特点。
 *
 * 高耦合的表现：
 *
 * 类之间的紧密依赖：Car 依赖于 Framework，Framework 依赖于 Bottom，Bottom 依赖于 Tire。这些类之间的依赖关系是直接的和紧密的，每个类都在自己的构造函数中创建其他类的实例。
 * 直接实例化：每个类都直接在构造函数中实例化其他类，导致这些类之间的耦合度很高。例如，Car 的构造函数直接创建了 Framework 的实例，Framework 的构造函数直接创建了 Bottom 的实例，Bottom 的构造函数直接创建了 Tire 的实例。
 * 低内聚的表现：
 *
 * 单一职责原则的违背：类的职责划分不是很明确。例如，Car 不仅负责汽车的行为，还负责初始化框架；Framework 不仅负责框架的行为，还负责初始化底盘。
 * 为了降低耦合度和提高内聚性，可以考虑以下改进：
 *
 * 依赖注入：使用依赖注入（Dependency Injection）将依赖关系注入到类中，而不是在类的内部直接创建实例。这可以通过构造函数注入、方法注入或者字段注入来实现。
 * 工厂模式：使用工厂模式（Factory Pattern）来创建实例，而不是在类内部直接创建实例。
 * 接口和抽象：使用接口和抽象类来解耦具体实现。
 * 以下是使用依赖注入和工厂模式改进后的代码示例：
 *
 */
public class Main {
    //高耦合
    public static void main(String[] args) {
        Car car = new Car(12);
        car.run();

        Car car1 = new Car(21);
        car1.run();
    }
}
