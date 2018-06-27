package com.didispace.feignconsumer.service;

import com.didispace.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient(value = "hello-service")
public interface RefactorHelloService extends HelloService {
}
