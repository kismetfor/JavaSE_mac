package com.bite.springioc.v1;

public class Bottom {
    private Tire tire;

    public Bottom(int size) {
        tire = new Tire(size);
        System.out.println("Tire get");
    }
}
