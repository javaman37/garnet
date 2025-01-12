package com.max.garnet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.max.garnet.dto.CheatingHistoryDTO;
import com.max.garnet.dto.MaxWinningDTO;

public interface BetService {
	Page<MaxWinningDTO> getMaxWinnings(Pageable pageable);
	Page<CheatingHistoryDTO> getCheatingHistory(Pageable pageable);

}
