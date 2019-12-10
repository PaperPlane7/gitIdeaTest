package com.zym.pojo;

import org.springframework.stereotype.Component;

//等价于<bean id = "user" class = "...."/>
//组件
@Component
public class User {
    public String name = "住宅";
}
