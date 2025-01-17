package com.max.garnet.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.max.garnet.dao.BetDAO;
import com.max.garnet.dto.PartnerDTO;
import com.max.garnet.entities.Partner;

public class PartnerServiceImpl implements PartnerService {
	
	@Autowired
	private BetDAO betDAO;
	
	public List<PartnerDTO> calculateStatistics(List<Partner> partners) {
	    return partners.stream().map(partner -> {
	        BigDecimal totalBets = betDAO.calculateTotalBets(partner.getId());
	        BigDecimal totalLosses = betDAO.calculateTotalLosses(partner.getId());

	        BigDecimal rollingPercentage = totalBets.equals(BigDecimal.ZERO)
	            ? BigDecimal.ZERO
	            : totalBets.divide(partner.getRolling(), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));

	        BigDecimal losingPercentage = totalLosses.equals(BigDecimal.ZERO)
	            ? BigDecimal.ZERO
	            : totalLosses.divide(totalBets, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));

	        return new PartnerDTO(
	            partner.getName(),
	            partner.getBalance(),
	            partner.getMoneyHeld(),
	            rollingPercentage,
	            losingPercentage,
	            partner.getRegistrationDate()
	        );
	    }).collect(Collectors.toList());
	}


}
