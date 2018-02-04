package com.sanshao90.blog.repository;

import com.sanshao90.blog.BlogApplication;
import com.sanshao90.blog.domain.User;
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
 * @Date : 2018/2/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        userRepository.save(User.of("aa", 10));
        userRepository.save(User.of("bb", 20));
        userRepository.save(User.of("cc", 30));
        userRepository.save(User.of("dd", 40));
        userRepository.save(User.of("ee", 50));
        userRepository.save(User.of("ff", 60));
        userRepository.save(User.of("gg", 70));
        userRepository.save(User.of("hh", 80));
        userRepository.save(User.of("ii", 90));

        Assert.assertEquals(9, userRepository.findAll().size());

        Assert.assertEquals(50, userRepository.findByName("ee").getAge().longValue());

        Assert.assertEquals(60, userRepository.findUser("ff").getAge().longValue());

        Assert.assertEquals("hh", userRepository.findByNameAndAge("hh", 80).getName() );

        userRepository.delete(userRepository.findByName("aa"));

        Assert.assertEquals(8, userRepository.findAll().size());
    }
}
