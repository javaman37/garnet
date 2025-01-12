package com.max.garnet.dao;

import java.math.BigDecimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    
    @Query("SELECT b FROM Bet b WHERE b.winAmount = (SELECT MAX(b2.winAmount) FROM Bet b2)")
    Page<Bet> findMaxWinnings(Pageable pageable);
    
    @Query("SELECT b FROM Bet b WHERE b.isCheating = TRUE")
    Page<Bet> findCheatingBets(Pageable pageable);

}
