package com.example.userCrud.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userCrud.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

}
