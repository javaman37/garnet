package com.max.garnet.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.max.garnet.entities.Bet;

@Repository
public interface BetDAO extends JpaRepository<Bet, Long> {
	
	@Query("SELECT SUM(b.betAmount) FROM Bet b WHERE b.userId = :userId AND b.gameType = 'SLOT'")
    BigDecimal getBettingSlotByUserId(Long userId);

    @Query("SELECT SUM(b.winAmount) FROM Bet b WHERE b.userId = :userId AND b.gameType = 'SLOT'")
    BigDecimal getWinningSlotByUserId(Long userId);

    @Query("SELECT SUM(b.betAmount) FROM Bet b WHERE b.userId = :userId AND b.gameType = 'CASINO'")
    BigDecimal getBettingCasinoByUserId(Long userId);

    @Query("SELECT SUM(b.winAmount) FROM Bet b WHERE b.userId = :userId AND b.gameType = 'CASINO'")
    BigDecimal getWinningCasinoByUserId(Long userId);

}
