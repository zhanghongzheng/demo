package com.test.zhz.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhz on 18/1/15.
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String home() {
        System.out.println("spring boot Hello World");
        return "spring boot Hello World";
    }
}
