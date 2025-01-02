package com.max.garnet.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	    private Long id;
	    private String username;
	    private String email;
	    private String nickname;
	    private String role;
	    private Double balance;
	    private Double rolling;
	    private String partnerName;
	    private BigDecimal beforeRepayment;
	    private BigDecimal moneyHeld;
	    

}
