package com.sanshao90.blog.redis;

import com.sanshao90.blog.BaseTest;
import com.sanshao90.blog.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/6
 */
public class RedisConfigTest extends BaseTest {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test() {
        User user = User.of("超人", 20);
        redisTemplate.opsForValue().set(user.getName(), user);
        user = User.of("蝙蝠人", 30);
        redisTemplate.opsForValue().set(user.getName(), user);
        user = User.of("蜘蛛人", 40);
        redisTemplate.opsForValue().set(user.getName(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().intValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠人").getAge().intValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛人").getAge().intValue());
    }
}
