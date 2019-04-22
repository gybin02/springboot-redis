package com.example.demo.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * @author pancm
 * @Title: User
 * @Description:用户pojo类
 * @Version:1.0.0
 * @date 2017年9月26日
 */
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    public User() {
    }


    /**
     * 获取编号
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param int age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     */
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "";
        }
    }


}
