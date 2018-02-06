package com.sanshao90.blog.mongodb.repository;

import com.sanshao90.blog.BaseTest;
import com.sanshao90.blog.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/6
 */
public class UserRepositoryTest extends BaseTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test()  {
        userRepository.save(User.of(1L,"didi", 30));
        userRepository.save(User.of(2L,"mama", 40));
        userRepository.save(User.of(3L, "kaka", 50));

        Assert.assertEquals(3, userRepository.findAll().size());

        User user = userRepository.findOne(1L);
        userRepository.delete(user);
        Assert.assertEquals(2, userRepository.findAll().size());

        user = userRepository.findByName("mama");
        userRepository.delete(user);
        Assert.assertEquals(1, userRepository.findAll().size());

    }
}
