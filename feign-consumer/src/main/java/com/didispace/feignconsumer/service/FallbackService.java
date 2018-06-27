package com.didispace.feignconsumer.service;

import com.didispace.feignconsumer.dto.User;
import org.springframework.stereotype.Component;

@Component
public class FallbackService implements HelloService {

    @Override
    public String hello(){
        return "服务降级处理";
    }

    @Override
    public String hello(String name){
        return "服务降级处理";
    }

    @Override
    public String hello(User user){
        return "服务降级处理";
    }

    @Override
    public User hello(String name ,Integer age){
        return new User("EIEI",18);
    }
}
