package com.example.userCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userCrud.dto.User;
import com.example.userCrud.dto.UserDto;
import com.example.userCrud.service.UserService;
import com.example.userCrud.serviceImp.UserServiceImp;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController 
{
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public String saveUser(@RequestBody User user)
	{
		userService.saveUser(user);
		return "Data Inserted";
	}
	
	@PostMapping("/users")
	public String saveAll(@RequestBody List<User> user)
	{
		userService.saveAllUser(user);
		return"Saved All";
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable int id ,@RequestBody User user) 
	{
		return userService.userUpdate(id, user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUser() 
	{
		return userService.getAllUser();
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteById(@PathVariable int id) 
	{
		userService.deleteUser(id);
		return "User Deleted";
	}
	
	@DeleteMapping("/users")
	public String deleteAllUser() 
	{
		userService.deleteAll();
		return "All User Deleted";
	}
	
	//user dto
	@PostMapping("/userdto")
	public String save(@RequestBody UserDto userDto) 
	{
		userService.saveDtoUser(userDto);
		return "Data saved";
		
	}
	@PutMapping("/userdto/{id}")
	public String update(@PathVariable int id,@RequestBody UserDto userDto) 
	{
		return userService.update(id, userDto);
		
	}
	
	//get user by id
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
		
}
