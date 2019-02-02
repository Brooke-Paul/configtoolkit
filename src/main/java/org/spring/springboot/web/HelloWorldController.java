package org.spring.springboot.web;

import org.spring.springboot.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视图返回
 */
@RestController
public class HelloWorldController {

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }


    @RequestMapping("/to404")
    public String to404() {
        return "not found to404";
    }

    /**
     * 第二种方式
     * @return
     */
    @RequestMapping("/getValue")
    public String getValue() {
        return address.getKey() + address.getValue();
    }
}
