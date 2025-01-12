package com.max.garnet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheatingHistoryDTO {
	//private Long id; // ID đặt cược
    private String user; // Tên người dùng
    private String gameCompany; // Công ty game
    private String gameName; // Tên trò chơi
    private String roundId; // ID vòng chơi
    private BigDecimal amountAfterBetting; // Số tiền còn lại sau đặt cược
    private BigDecimal winnings; // Số tiền thắng
    private BigDecimal fraudulentAmount; // Số tiền gian lận
    private LocalDateTime date; // Thời gian đặt cược
    private String checkStatus; // Trạng thái kiểm tra (VD: Confirmed, Pending)
}

