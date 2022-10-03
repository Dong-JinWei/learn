package com.atguigu.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
        // 验证码发送
        verifyCode("15353169794");
        getRedisCode("15353169794", "997565");
        getRedisCode("15353169794", "243244");
    }

    // 1. 生成6为验证吗
    public static String getCode(){
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++){
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }

    // 2. 每个手机每天只能发送三次，放到redis中，设置过期时间
    public static void verifyCode(String phone) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 拼接key
        String countKey = "VerifyCode" + phone + ":count";
        // 拼接验证码
        String codeKey = "VerifyCode" + phone + ":code";

        // 每个手机只能发送三次
        String count = jedis.get(countKey);
        if (count == null) {
            // 设置发送次数是1
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            // 发送次数加1
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("今天发送的次数超过三次");
            jedis.close();
            return;
        }

        // 发送的验证码放到redis中
        String vcode = getCode();
        jedis.setex(codeKey, 120, vcode);
        jedis.close();
    }

    // 3 验证码校验
    public static void getRedisCode(String phone, String code){
        // 从redis中获取验证码
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String codeKey = "VerifyCode" + phone + ":code";
        String redisCode = jedis.get(codeKey);
        // 判断
        if(redisCode.equals(code)){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
        jedis.close();
    }
}
