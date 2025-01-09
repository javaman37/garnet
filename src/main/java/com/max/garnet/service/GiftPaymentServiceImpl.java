package com.max.garnet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.max.garnet.dao.GiftPaymentDAO;
import com.max.garnet.dto.GiftPaymentDTO;
import com.max.garnet.entities.GiftPayment;

public class GiftPaymentServiceImpl implements GiftPaymentService {
	
	private  GiftPaymentDAO giftPaymentDAO;

	@Override
	public Page<GiftPaymentDTO> getGiftsForReceiver(Long receiverId, Pageable pageable) {
		return giftPaymentDAO.findAllByReceiverId(receiverId, pageable)
	            .map(this::convertToDTO);
	}
	
	private GiftPaymentDTO convertToDTO(GiftPayment giftPayment) {
        return new GiftPaymentDTO(
            giftPayment.getReceiver().getId(),  // ID của người nhận
            giftPayment.getReceiver().getNickname(), // Nickname của người nhận
            giftPayment.getGiftAmount(), // Số tiền quà
            giftPayment.getAmountReceived(), // Số tiền nhận được
            giftPayment.getSentDateTime() // Ngày gửi
        );
    }

}
