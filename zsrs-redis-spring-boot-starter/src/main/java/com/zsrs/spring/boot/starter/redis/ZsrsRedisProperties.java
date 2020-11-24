package com.zsrs.spring.boot.starter.redis;


import org.springframework.boot.context.properties.ConfigurationProperties;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Create By IntelliJ IDEA
 *
 * @author LiLong
 * @date 2020/11/16
 */
@ConfigurationProperties(prefix = "zsrs.redis")
public class ZsrsRedisProperties {

    private String host;

    private int port;

    private String password;

    private String prefix;

    private int timeout;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }


    /**
     * 初始化Redis连接池
     */
    public JedisPool getJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(20000);
        config.setMaxIdle(100);
        config.setMinIdle(1);
        config.setNumTestsPerEvictionRun(10);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        config.setTestWhileIdle(true);
        config.setTestOnCreate(false);
        config.setTimeBetweenEvictionRunsMillis(30000);
        JedisPool myJedisPool = new JedisPool(config, host, port, timeout, password);
        return myJedisPool;
    }




}
