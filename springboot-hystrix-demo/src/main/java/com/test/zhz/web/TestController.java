package com.test.zhz.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhz on 18/1/15.
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "fallback")
    public String hello() throws Exception {
        Thread.sleep(3000);
        System.out.println("springboot-hystrix Hello World");
        return "springboot-hystrix Hello World";
    }

    public String fallback() {
        return "fallbck";
    }


}
