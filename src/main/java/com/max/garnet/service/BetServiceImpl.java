package com.max.garnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.max.garnet.dao.BetDAO;
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

}
