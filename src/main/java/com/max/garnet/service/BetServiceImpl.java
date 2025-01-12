package com.max.garnet.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.max.garnet.dao.BetDAO;
import com.max.garnet.dto.CheatingHistoryDTO;
import com.max.garnet.dto.MaxWinningDTO;
import com.max.garnet.entities.Bet;

@Service
public class BetServiceImpl implements BetService {
	
	@Autowired
    private BetDAO betDAO;

	

	@Override
	public Page<MaxWinningDTO> getMaxWinnings(Pageable pageable) {
		Page<Bet> maxBets = betDAO.findMaxWinnings(pageable);
        return maxBets.map(bet -> new MaxWinningDTO(
                bet.getUser().getId(),
                bet.getGameCompany(),
                bet.getGameName(),
                bet.getRoundId(),
                bet.getBet_amount(),
                bet.getBet_amount(),
                bet.getCreated_at(),
                "Confirmed" // Placeholder for "check" field
        ));
	}
	
	@Override
    public Page<CheatingHistoryDTO> getCheatingHistory(Pageable pageable) {
		Page<Bet> cheatingBets = betDAO.findCheatingBets(pageable);

	    return cheatingBets.map(bet -> {
	        String checkStatus = bet.getFraudulentAmount().compareTo(BigDecimal.ZERO) > 0 ? "Confirmed" : "check";

	        return new CheatingHistoryDTO(
	            bet.getUser().getUsername(),
	            bet.getGameCompany(),
	            bet.getGameName(),
	            bet.getRoundId(),
	            bet.getBet_amount().subtract(bet.getWin_amount()), // Amount after betting
	            bet.getWin_amount(),
	            bet.getFraudulentAmount(),
	            bet.getCreated_at(),
	            checkStatus // Tính toán trước và truyền vào đây
	        );
	    });
	}

}
