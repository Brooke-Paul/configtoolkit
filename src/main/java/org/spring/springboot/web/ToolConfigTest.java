package org.spring.springboot.web;

import com.dangdang.config.service.ConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigProfile;
import org.spring.springboot.Address;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author xuetao
 * @Description: TODO
 * @Date 2019-02-02
 * @Version 1.0
 */
public class ToolConfigTest {

    public static void main(String[] args) {
        ZookeeperConfigProfile configProfile = new ZookeeperConfigProfile("192.168.31.12:2181", "/root", "1.0.0");
        ConfigGroup zkConfigGroup = new ZookeeperConfigGroup(configProfile, "address");



        while (true) {
            Object obj = "chengdu";
            System.out.println("第一种方式：：" + zkConfigGroup.get(obj));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
