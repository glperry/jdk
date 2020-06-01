package com.glperry.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * User进行读写/网络间传输
 * @date:2020/5/30 13:44
 */
public class User implements Serializable {

    private String name;
    private String password;
    private static int count =0;

    public User() {
        System.out.println("采用的是无参构造进行传输,反序列化");
    }


    public User(String name, String password) {
        if (count==0){
            System.out.println("有参构造进行初始化");
        }else if(count==1){
            System.out.println("采用的是有参构造进行传输,反序列化");
        }
        this.name = name;
        this.password = password;
    }
}
