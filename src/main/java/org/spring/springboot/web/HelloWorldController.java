package org.spring.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视图返回
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }

    @RequestMapping("/error")
    public String error() {
        return "not found error";
    }

    @RequestMapping("/to404")
    public String to404() {
        return "not found to404";
    }
}
