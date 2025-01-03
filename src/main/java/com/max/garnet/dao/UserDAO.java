package com.max.garnet.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.max.garnet.dto.UserDTO;
import com.max.garnet.entities.User;

public interface UserDAO extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	
	@Query("SELECT new com.example.dto.UserDTO(u.id, u.username, u.email, u.nickname, u.role, u.balance, u.rolling, p.name) " +
	           "FROM User u " +
	           "LEFT JOIN u.partner p " +
	           "WHERE (:filter IS NULL OR u.username LIKE %:filter% OR u.email LIKE %:filter% OR u.nickname LIKE %:filter%) " +
	           "AND (:partnerId IS NULL OR p.id = :partnerId)")
	Page<UserDTO> findUsersByFilterAndPartner(String filter, Long partnerId, Pageable pageable);

	@Query("SELECT u FROM User u JOIN u.affiliation a WHERE u.situation = 'PENDING'")
	Page<User> findPendingUsers(Pageable pageable);
	
	@Query("SELECT u FROM User u WHERE u.role = 'CONNECTOR'")
    Page<User> findAllConnectors(Pageable pageable);

}
