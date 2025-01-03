package com.max.garnet.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.max.garnet.entities.Transaction;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Long> {
	
	 @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.userId = :userId AND t.type = 'DEPOSIT'")
	    BigDecimal getTotalDepositByUserId(Long userId);

	    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.userId = :userId AND t.type = 'WITHDRAWAL'")
	    BigDecimal getTotalWithdrawalByUserId(Long userId);

}
