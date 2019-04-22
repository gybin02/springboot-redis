package com.example.demo;

import com.example.demo.config.RestTemplateConfig;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Autowired
    UserDao dao;

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setId(1);
        user.setName("name");
        user.setAge(23);
        dao.addUser(user);

    }


    @Test
    public void restGet() throws JsonProcessingException {
        String url="https://api.apiopen.top/EmailSearch?number=1012002";
        ResponseEntity<JSONObject> entity = restTemplate.getForEntity(url, JSONObject.class);
        JSONObject json = entity.getBody();
//        ObjectMapper mapper = new ObjectMapper();
        assert json != null;
        System.out.println(json.toString());

    }

}
