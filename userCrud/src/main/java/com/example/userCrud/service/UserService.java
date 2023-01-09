package com.example.userCrud.service;

import java.util.List;

import com.example.userCrud.dto.User;
import com.example.userCrud.dto.UserDto;

public interface UserService 
{
	User saveUser(User user);
	User userUpdate(int id,User user);
	List<User> getAllUser();
	void deleteUser(int id);
	List<User> saveAllUser(List<User> user);
	void deleteAll();
	UserDto saveDtoUser(UserDto userDto);
	String update(int id, UserDto UserDto);
	User getUserById(int id);
}
