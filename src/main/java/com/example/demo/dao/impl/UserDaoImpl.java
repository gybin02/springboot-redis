package com.example.demo.dao.impl;

import javax.annotation.Resource;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.util.RedisUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;


/**
 * @author pancm
 * @Title: UserDaoImpl
 * @Description:
 * @Version:1.0.0
 * @date 2018年8月15日
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private RedisUtil redisUtil;

    /**
     *
     */
    @Override
    public void addUser(User user) {
        redisUtil.set(String.valueOf(user.getId()), user.toString());
    }

    /**
     *
     */
    @Override
    public void updateUser(User user) {
        redisUtil.set(String.valueOf(user.getId()), user.toString());
    }

    /**
     *
     */
    @Override
    public void deleteUser(int id) {
        redisUtil.del(String.valueOf(id));
    }

    /**
     *
     */
    @Override
    public User findByUserId(int id) {
        String data = redisUtil.get(String.valueOf(id)).toString();
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(data, User.class);
//		User user = JSON.parseObject(data, User.class);
        return user;
    }

}
