package com.max.garnet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.max.garnet.dto.UserDTO;
import com.max.garnet.service.UserService;

public class AdminController {
	
	 @Autowired
	    private UserService userService;
	 
	 @GetMapping("/users")
	    public ResponseEntity<Page<UserDTO>> getUsers(
	        @RequestParam(value = "filter", required = false) String filter,
	        @RequestParam(value = "partnerId", required = false) Long partnerId,
	        Pageable pageable
	    ) {
	        Page<UserDTO> users = userService.getUsers(pageable, filter, partnerId);
	        return ResponseEntity.ok(users);
	    }

}
