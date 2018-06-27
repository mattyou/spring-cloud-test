package com.didispace.feignconsumer.web;


import com.didispace.dto.User;
import com.didispace.feignconsumer.service.HelloService;
import com.didispace.feignconsumer.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController{
    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    //feign复制方式绑定服务接口
    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append("/feign-consumer2").append("<br/>");
        sb.append(helloService.hello()).append("<br/>");
        sb.append(helloService.hello("DIDI")).append("<br/>");
        sb.append(helloService.hello("IDID",20)).append("<br/>");
        sb.append(helloService.hello(new com.didispace.feignconsumer.dto.User("DIDI",20)));

        return sb.toString();
    }

    //feign继承方式绑定服务接口
    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append("/feign-consumer3").append("<br/>");
        sb.append(refactorHelloService.hello("DIDI")).append("<br/>");
        sb.append(refactorHelloService.hello("IDID",30)).append("<br/>");
        sb.append(refactorHelloService.hello(new User("DIDI",30))).append("<br/>");

        return sb.toString();
    }
}
