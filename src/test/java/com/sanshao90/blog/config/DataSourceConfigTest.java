package com.sanshao90.blog.config;

import com.sanshao90.blog.BlogApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class DataSourceConfigTest {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate2;

    @Before
    public void setUp() {
        jdbcTemplate1.update("DELETE from USER ");
        jdbcTemplate2.update("DELETE from USER ");
    }

    @Test
    public void test() {
        jdbcTemplate1.update("insert into user (id, name, age) values (?,?,?)", 1, "aaa", 20);
        jdbcTemplate1.update("insert into user (id, name, age) values (?,?,?)", 2, "bbb", 30);

        jdbcTemplate2.update("insert into user (id, name, age) values (?,?,?)", 1, "ddd", 40);

        Assert.assertEquals(2, Integer.valueOf(jdbcTemplate1.queryForObject("select count(*) from user", String.class)).intValue());

        Assert.assertEquals(1, Integer.valueOf(jdbcTemplate2.queryForObject("select count(*) from user", String.class)).intValue());
    }

}
