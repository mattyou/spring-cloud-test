package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
//spring boot 入口文件自动扫描bean的路径是本包，所以当controller包和入口文件不在一个包时，访问服务会出现404错误
//简单的做法是把入口文件放在父包中（或者，根包）,否则手工添加ComponentScan注解，如下：
//@ComponentScan(basePackages = "com.didispace.web")

public class HelloServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServiceApplication.class, args);
    }
}
