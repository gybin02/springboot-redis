package com.example.demo.dao;


import com.example.demo.pojo.User;

/**
 * 
* Title: UserDao
* Description:
* 用户数据接口 
* Version:1.0.0  
* @author pancm
* @date 2018年1月9日
 */
public interface UserDao {
	
	/**
	 * 用户数据新增
	 */
	  void addUser(User user);
	 
	 /**
	  * 用户数据修改
	  */
	  void updateUser(User user);

	 /**
	  * 用户数据删除
	 */
	 void deleteUser(int id);
	
	
    /**
     * 查询
     */   
	 User findByUserId(int id);
    
}
