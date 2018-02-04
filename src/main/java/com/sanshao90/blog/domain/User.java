package com.sanshao90.blog.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/4
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable =  false)
    @NonNull
    private String name;
    @Column(nullable = false)
    @NonNull
    private Integer age;
}
