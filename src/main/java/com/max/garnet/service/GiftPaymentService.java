package com.max.garnet.service;

import com.max.garnet.dto.GiftPaymentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GiftPaymentService {
	Page<GiftPaymentDTO> getGiftsForReceiver(Long receiverId, Pageable pageable);
}
