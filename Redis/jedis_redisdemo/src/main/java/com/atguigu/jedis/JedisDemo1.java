package com.atguigu.jedis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        // 创建jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 测试
        String ping = jedis.ping();
        System.out.println(ping);
    }


    @Test
    public void demo1(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 添加
        jedis.set("name","lucy");

        // 获取
        String name = jedis.get("name");
        System.out.println(name);

        // 设置多个key-value
        String mset = jedis.mset("k1", "v1", "k2", "v2");
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    public void demo2(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.lpush("key1", "lucy", "mary", "jack");
        List<String> values = jedis.lrange("key1", 0, -1);
        System.out.println(values);

    }

    @Test
    public void demo3(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.sadd("names", "lucy");
        jedis.sadd("names", "jack");
        Set<String> names = jedis.smembers("names");
        System.out.println(names);

    }

    @Test
    public void demo4(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.hset("users", "age", "20");
        String hget = jedis.hget("users", "age");
        System.out.println(hget);

    }

    @Test
    public void demo5(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.zadd("china", 100d, "shanghai");
        Set<String> china = jedis.zrange("china", 0, -1);
        System.out.println(china);
    }

}
