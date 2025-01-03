package com.max.garnet.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectorDTO {
	
	private Long id; // CONNECTION ID
    private String nickname;
    private String depositorName; // Tên người gửi tiền (nếu có)
    private String affiliationName; // Tên của Affiliation
    private BigDecimal moneyHeld;
    private BigDecimal beforeRepayment;
    private BigDecimal totalDeposit;
    private BigDecimal totalWithdrawal;
    private BigDecimal bettingSlot;
    private BigDecimal winningSlot;
    private BigDecimal bettingCasino;
    private BigDecimal winningCasino;
    private String recentlyPlayedGames;
    private String detailsUrl; // URL để xem chi tiết
    
    


}
