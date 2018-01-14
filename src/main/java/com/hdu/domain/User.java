package com.hdu.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 范正荣
 * @Date 2017/12/16 0016 19:21.
 * User 实体
 */
@Entity
public class User {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略 自增
    private Long id;
    private String name;
    private String email;

    protected User(){}
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', email='%s']",
                id, name, email);
    }
}
