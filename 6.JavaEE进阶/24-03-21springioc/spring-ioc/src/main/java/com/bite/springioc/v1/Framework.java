package com.bite.springioc.v1;

public class Framework {
    private Bottom bottom;

    public Framework(int size) {
        bottom = new Bottom(size);
        System.out.println("bottom get");
    }
}
