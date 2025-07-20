package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsername(String username);
	boolean existsByUsername(String username);

}
