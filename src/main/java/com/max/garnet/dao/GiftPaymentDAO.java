package com.max.garnet.dao;

import com.max.garnet.entities.GiftPayment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftPaymentDAO extends JpaRepository<GiftPayment, Long> {
	@Query("SELECT g FROM GiftPayment g WHERE g.receiver.id = :receiverId")
    Page<GiftPayment> findAllByReceiverId(Long receiverId, Pageable pageable);
}
