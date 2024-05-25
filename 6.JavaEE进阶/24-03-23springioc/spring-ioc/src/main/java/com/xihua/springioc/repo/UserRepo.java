package com.xihua.springioc.repo;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    public void doRepository(){
        System.out.println("do Repository");
    }
}
