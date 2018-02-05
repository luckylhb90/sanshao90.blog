package com.sanshao90.blog.config;

import com.sanshao90.blog.BlogApplication;
import com.sanshao90.blog.domain.User;
import com.sanshao90.blog.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class JpaConfigTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        userRepository.save(User.of("aaa", 10));
        userRepository.save(User.of("bbb", 20));
        userRepository.save(User.of("ccc", 30));
        userRepository.save(User.of("ddd", 40));
        userRepository.save(User.of("eee", 50));

        Assert.assertEquals(5, userRepository.findAll().size());


    }
}
