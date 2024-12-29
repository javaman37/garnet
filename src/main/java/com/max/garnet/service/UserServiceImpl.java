package com.max.garnet.service;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.max.garnet.dto.UserDTO;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDAO userDAO;

	@Override
	public Page<UserDTO> getUsers(Pageable pageable, String filter, Long partnerId) {
		return userDAO.findUsersByFilterAndPartner(filter, partnerId, pageable);
	}

}
