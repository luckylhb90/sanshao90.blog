package com.sanshao90.blog.web.controller.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mock;
    private RequestBuilder request;

    @Before
    public void setUp() {
        mock = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void test_All() throws Exception {
        this.test_getUserList();
        this.test_postUser();
        this.test_putUser();
        this.test_getUser();
        this.test_deleteUser();
        this.test_getUserList();
    }

    @Test
    public void test_getUserList() throws Exception {
        request = get("/users/");
        mock.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void test_postUser() throws Exception {
        request = post("/users/")
        .param("id", "1")
        .param("name", "测试")
        .param("age", "28");

        mock.perform(request)
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void test_putUser() throws Exception {
        request = put("/users/1").param("name", "测试")
        .param("age", "38");
        mock.perform(request)
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void test_getUser() throws Exception {
        request = get("/users/");
        mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试\",\"age\":38}]")));
    }

    @Test
    public void test_deleteUser() throws Exception {
        request = delete("/users/1");
        mock.perform(request)
                .andExpect(content().string(equalTo("success")));
    }


}
