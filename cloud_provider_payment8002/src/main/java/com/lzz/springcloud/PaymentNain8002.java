package com.lzz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
* @auther: li
* @time: 20210417 17:40
* */
@SpringBootApplication
@EnableEurekaClient
public class PaymentNain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNain8002.class, args);
    }
}
