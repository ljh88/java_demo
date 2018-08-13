package com.china.mapper;

import java.util.List;

import com.china.pojo.User;

public interface UserMapper {

	 public User findUserById(int id) throws Exception;
	 public List<User> findUserByName(String name) throws Exception;
	 public void deleteUserById(int id) throws Exception;
	
	 public void insertUser(User user) throws Exception;
	 public void updateUserById(User user) throws Exception;
	 public int findUserCount() throws Exception;
}
