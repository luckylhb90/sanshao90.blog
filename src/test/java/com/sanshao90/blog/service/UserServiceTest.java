package com.sanshao90.blog.service;

import com.sanshao90.blog.BlogApplication;
import org.junit.Assert;
import org.junit.Before;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        userService.deleteAllUsers();
    }

    @Test
    public void test() {
        userService.add("a", 1);
        userService.add("b", 2);
        userService.add("c", 3);
        userService.add("d", 4);
        userService.add("e", 5);

        Assert.assertEquals(5, userService.getAllUsers().intValue());

        userService.deleteByName("a");
        userService.deleteByName("e");

        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }
}
