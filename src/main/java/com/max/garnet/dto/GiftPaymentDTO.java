package com.max.garnet.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftPaymentDTO {
    private Long memberId;          // ID của người dùng
    private String memberNickname;  // Nickname của người dùng
    private BigDecimal giftAmount;  // Số tiền gửi quà
    private BigDecimal amountReceived; // Số tiền nhận được
    private LocalDateTime sentDateTime; // Ngày và giờ gửi quà
}
