package com.max.garnet.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.max.garnet.entities.Partner;

public interface PartnerDAO extends JpaRepository<Partner, Long> {
	
	

}
