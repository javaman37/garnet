package com.max.garnet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.max.garnet.dto.UserDTO;

public interface UserService {
	Page<UserDTO> getUsers(Pageable pageable, String filter, Long partnerId);

}
