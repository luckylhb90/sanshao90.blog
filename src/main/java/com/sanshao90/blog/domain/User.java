package com.sanshao90.blog.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Project : sanshao90.blog
 * @Description : TODO
 * @Author : sanshao90
 * @Date : 2018/2/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -1502355675352383565L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable =  false)
    @NonNull
    private String name;
    @Column(nullable = false)
    @NonNull
    private Integer age;

    public static User of (Long id, String name, Integer age) {
        return new User (id, name, age);
    }
}
