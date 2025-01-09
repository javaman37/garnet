package com.max.garnet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.max.garnet.dto.ConnectorDTO;
import com.max.garnet.dto.GiftPaymentDTO;
import com.max.garnet.dto.PendingUserDTO;
import com.max.garnet.dto.UserDTO;
import com.max.garnet.service.GiftPaymentService;
import com.max.garnet.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	 @Autowired
	 private UserService userService;
	 @Autowired
	 private GiftPaymentService giftPaymentService;
	 
	 
	 
	 @GetMapping("/list")
	    public ResponseEntity<Page<UserDTO>> getUsers(
	        @RequestParam(value = "filter", required = false) String filter,
	        @RequestParam(value = "partnerId", required = false) Long partnerId,
	        Pageable pageable
	    ) {
	        Page<UserDTO> users = userService.getUsers(pageable, filter, partnerId);
	        return ResponseEntity.ok(users);
	    }
	 
	 @GetMapping("/pending")
	    public ResponseEntity<Page<PendingUserDTO>> getPendingUsers(Pageable pageable) {
	        Page<PendingUserDTO> pendingUsers = userService.getPendingUsers(pageable);
	        return ResponseEntity.ok(pendingUsers);
	    }
	 
	 @GetMapping("/connection")
	    public ResponseEntity<Page<ConnectorDTO>> getAllConnectors(Pageable pageable) {
	        Page<ConnectorDTO> connectors = userService.getAllConnectors(pageable);
	        return ResponseEntity.ok(connectors);
	    }
	 
	 @GetMapping("/gift")
	    public Page<GiftPaymentDTO> getGifts(
	            @RequestParam Long receiverId, // ID của người nhận
	            Pageable pageable) {
	        return giftPaymentService.getGiftsForReceiver(receiverId, pageable);
	    }

}
