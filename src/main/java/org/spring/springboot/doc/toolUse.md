# 分布配置工具搭建

## 第一步 克隆当当config-toolkit项目

```java
git clone https://github.com/dangdangdotcom/config-toolkit
```

## 第二步 进入config-face目录

```java
mvn package
cd config-face/target/
java -jar config-face.jar --zk="localhost:2181"
```

## 第三步 设置节点名称与密码

```java
使用sha1加密
python -c "import hashlib;print hashlib.sha1('123456').hexdigest();"
7c4a8d09ca3762af61e59520943dc26494f8941b
zkCli -server localhost:2181
create /root 
create /root 7c4a8d09ca3762af61e59520943dc26494f8941b
```

## 第四步 java实现分布式管理

```java
第一种方式：   
通过java代码直连   

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
```
第二种方式：   
通过xml配置设值注入属性值      
```xml
 <config:group id="groupProp" node="address"/>
    <bean id="address" class="org.spring.springboot.Address">
        <property name="key" value="#{groupProp['chengdu']}" />
        <property name="value" value="第三种方式" />
    </bean>
    
```
```java
@Autowired
private Address address;
@RequestMapping("/getValue")
public String getValue() {
    return address.getKey() + address.getValue();
 } 
```