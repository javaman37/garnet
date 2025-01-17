package com.max.garnet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDTO {
    private String connectionId;
    private String form; // Vai trò
    private BigDecimal moneyHeld;
    private BigDecimal rolling;
    private BigDecimal rollingPercentage;
    private BigDecimal losingPercentage;
    private LocalDateTime registrationDate;
    private BigDecimal bettingSL;
    private BigDecimal bettingCAR;
    private BigDecimal bettingPAR;
}
