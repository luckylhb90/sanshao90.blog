package com.sanshao90.blog.service;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/4
 */
public interface UserService {

    void add(String name, Integer age);

    void deleteByName(String name);

    Integer getAllUsers();

    void deleteAllUsers();
}
