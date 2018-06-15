package com.didispace;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 翟永超
 * @create 2017/4/15.
 * @blog http://blog.didispace.com
 */
@RestController
public class DcController {


    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "fallback2")
    public String hello() throws Exception {
        Thread.sleep(5000);//触发
        return "springcloud-hystrix-demo hello world";
    }


    public String fallback2() {
        return "fallbck2";
    }




    /** 调用远程服务的demo */
    @Autowired
    ConsumerService consumerService;
    @GetMapping("/hello2")
    public String dc() {
        return consumerService.consumer();
    }


    @Service
    class ConsumerService {

        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer() {
            return restTemplate.getForObject("http://eureka-client/dc", String.class);
        }

        public String fallback() {
            return "fallbck";
        }

    }

}
