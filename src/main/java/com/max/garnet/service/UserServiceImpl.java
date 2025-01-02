package com.max.garnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.max.garnet.dao.UserDAO;
import com.max.garnet.dto.PendingUserDTO;
import com.max.garnet.dto.UserDTO;
import com.max.garnet.entities.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDAO userDAO;

	@Override
	public Page<UserDTO> getUsers(Pageable pageable, String filter, Long partnerId) {
		return userDAO.findUsersByFilterAndPartner(filter, partnerId, pageable);
	}

	@Override
	public Page<PendingUserDTO> getPendingUsers(Pageable pageable) {
		 Page<User> users = userDAO.findPendingUsers(pageable);
	        return users.map(user -> new PendingUserDTO(
	            user.getId(),
	            user.getNickname(),
	            user.getSituation(),
	            user.getAffiliatedHeadquarters(),
	            user.getAffiliatedBranch(),
	            user.getAffiliatedDistributor(),
	            user.getAffiliatedStore(),
	            user.getRegistrationDate(),
	            user.getPhoneNumber(),
	            user.getApprovalStatus(),
	            "/user/details/" + user.getId()
	        ));
	    }
	}
	
	

}
