package org.spring.springboot;

import org.springframework.stereotype.Component;

/**
 * @Author xuetao
 * @Description: TODO
 * @Date 2019-02-03
 * @Version 1.0
 */
public class Address {
    /**
     * 地址
     */
    public String key;

    /**
     * value
     */
    public String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
