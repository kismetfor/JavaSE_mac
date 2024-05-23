package com.bite.springioc.v1;

public class Car {
    private Framework framework;

    public Car(int size) {
        framework = new Framework(size);
        System.out.println("framework初始化");
    }

    public void run() {
        System.out.println("car run...");
    }
}
