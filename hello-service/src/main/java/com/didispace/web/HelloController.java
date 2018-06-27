package com.didispace.web;


import com.didispace.dto.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class);


    @Autowired
    DiscoveryClient client;

    @Autowired
    Registration registration;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws InterruptedException {
        //client.getServices().forEach(id -> {
        //    client.getInstances(id).forEach(instance -> {
        //        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        //    });
        //});

        //测试熔断，随机延迟
        //int sleepTime = new Random().nextInt(3000);
        //logger.info("sleepTime:" + sleepTime);
        //Thread.sleep(sleepTime);

        logger.info("/hello, host:" + registration.getHost() + ":" + registration.getPort() + ", service_id:" + registration.getServiceId());

        return "hello cloud " + registration.getPort();
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
