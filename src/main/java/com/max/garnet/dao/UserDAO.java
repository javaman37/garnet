package com.max.garnet.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.max.garnet.entities.User;

public interface UserDAO extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
