# 常用spring-boot-starter集合

## zsrs-redis-spring-boot-starter
### 说明
基于spring boot自动装配机制，对jedis底层进行了封装，保留jedis的api，
在实际使用过程中，有可能很多项目公用同一套redis集群，添加prefix前缀，用来却分不用项目，防止造成key冲突。<br/>
依赖第三方jar如下：<br/>
spring boot：2.3.5.RELEASE<br/>
commons-pool2：2.8.0<br/>
jedis：2.9.0<br/>
### 用法
* 1.下载原代码，需要用maven进行构建，进入到/zsrs-spring-boot-starter目前下
执行 mvn install -Dmaven.test.skip=true，将jar安装到本地仓库中
* 2.加依赖，在目标项目中添加maven的依赖

``` 
<dependency>
    <groupId>com.zsrs</groupId>
    <artifactId>zsrs-redis-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
* 3.写配置，在Spring Boot配置文件中添加配置信息

```
zsrs:
  redis:
    database: 0
    host: 127.0.0.1
    port: 6379
    password: 
    timeout: 30000
    prefix: memo_
```
* 4.在代码中注入JedisTemplete

```java
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisTempleteTest {

    @Resource
    JedisTemplete jedisTemplete;

    @Test
    public void testGet(){
        String result = jedisTemplete.get("test");
        Assert.assertSame("1",result);
    }
}
```
----------

## zsrs-swagger-spring-boot-starter
### 说明 
对swagger使用配置进行了封装，简化了swagger使用方式。<br/>
swagger：2.9.2
### 用法
* 1.下载原代码，需要用maven进行构建，进入到/zsrs-spring-boot-starter目前下
执行 mvn install -Dmaven.test.skip=true，将jar安装到本地仓库中
* 2.加依赖，在目标项目中添加maven的依赖

``` 
<dependency>
    <groupId>com.zsrs</groupId>
    <artifactId>zsrs-swagger-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
* 3.写配置，在Spring Boot配置文件中添加配置信息

```
swagger:
  enable: true
  basePackage: com.ape.memo.controller
  title: 记忆猩接口文档
  description: 优雅的API文档
  version: v1.0
```

