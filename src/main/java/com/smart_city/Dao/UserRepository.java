package com.smart_city.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_city.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUsername(String username);
}
