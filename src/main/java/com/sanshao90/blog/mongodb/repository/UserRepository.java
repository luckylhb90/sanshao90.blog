package com.sanshao90.blog.mongodb.repository;

import com.sanshao90.blog.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/6
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByName(String name);
}
