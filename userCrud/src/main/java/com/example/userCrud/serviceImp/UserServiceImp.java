package com.example.userCrud.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userCrud.dto.User;
import com.example.userCrud.dto.UserDto;
import com.example.userCrud.repostory.RepositoryDto;
import com.example.userCrud.repostory.UserRepository;
import com.example.userCrud.service.UserService;
@Service
public class UserServiceImp implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RepositoryDto repostiorydto;
	
	@Override
	public User saveUser(User user) 
	{
		return userRepository.save(user);
	}

	@Override
	public User userUpdate(int id, User user) {
		User existUser=userRepository.findById(id).get();
		existUser.setName(user.getName());
		existUser.setAge(user.getAge());
		userRepository.save(existUser);
		return existUser;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public List<User> saveAllUser(List<User> user) {
		return userRepository.saveAll(user);
	}

	@Override
	public void deleteAll() 
	{
		userRepository.deleteAll();
	}

	//userdto
	@Override
	public UserDto saveDtoUser(UserDto userDto) {
	
	 return repostiorydto.save(userDto);
	}

	@Override
	public String update(int id, UserDto UserDto) {
		if(repostiorydto.existsById(id))
		{
			UserDto tempUser=repostiorydto.findById(id).get();
			if(tempUser.getName()!=null && tempUser.getId()!=0)
			{
				tempUser.setName(UserDto.getName());
				tempUser.setAge(UserDto.getAge());
				repostiorydto.save(tempUser);
				return "All Details updated";
			}
			else if (UserDto.getName()==null&& UserDto.getAge()!=0) {
				repostiorydto.save(tempUser);
				return "Age has been Updated";
			}
			else if (UserDto.getName()!=null&& UserDto.getAge()==0) {
				repostiorydto.save(tempUser);
				return "Name has been upadated";
			}
			else {
				return "not valid";
			}
			
	}
		else 
		{
			return "Data not found";
		}	
	}

	@Override
	public User getUserById(int id) {
		User getUser1=userRepository.findById(id).get();
		return getUser1;
	}
}
