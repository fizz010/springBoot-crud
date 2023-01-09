package com.example.userCrud.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userCrud.dto.UserDto;

public interface RepositoryDto extends JpaRepository<UserDto, Integer>
{

}
