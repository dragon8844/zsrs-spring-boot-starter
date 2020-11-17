# 常用spring-boot-starter集合

## zsrs-redis-spring-boot-starter
#### 用法
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




