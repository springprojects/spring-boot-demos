package com.gaodashang.demo;

/**
 * Created by eva on 2015/3/7.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class MainApplicationConfiguration {

    @Value("${com.gaodashang.message:wo shi zhong guo ren.}")
    private String message;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return message;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplicationConfiguration.class, args);
    }
}
