package com.max.garnet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaxWinningDTO {
	private Long userId;
    private String gameCompany;
    private String gameName;
    private String roundId;
    private BigDecimal betAmount;
    private BigDecimal winAmount;
    private LocalDateTime date;
    private String checkStatus;

}
