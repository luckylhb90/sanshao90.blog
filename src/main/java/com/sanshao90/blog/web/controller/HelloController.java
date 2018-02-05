package com.sanshao90.blog.web.controller;

import com.sanshao90.blog.exception.BLogException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/3
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping("/json")
    public String  json() throws BLogException {
        throw new BLogException("发生错误！");
    }
}
