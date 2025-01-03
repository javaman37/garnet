package com.max.garnet.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.max.garnet.dao.BetDAO;
import com.max.garnet.dao.TransactionDAO;
import com.max.garnet.dao.UserDAO;
import com.max.garnet.dto.ConnectorDTO;
import com.max.garnet.dto.PendingUserDTO;
import com.max.garnet.dto.UserDTO;
import com.max.garnet.entities.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private BetDAO betDAO;

	@Override
	public Page<UserDTO> getUsers(Pageable pageable, String filter, Long partnerId) {
		return userDAO.findUsersByFilterAndPartner(filter, partnerId, pageable);
	}

	@Override
	public Page<PendingUserDTO> getPendingUsers(Pageable pageable) {
		 Page<User> users = userDAO.findPendingUsers(pageable);
	        return users.map(user -> new PendingUserDTO(
	            user.getId(),
	            user.getNickname(),
	            user.getSituation(),
	            user.getAffiliatedHeadquarters(),
	            user.getAffiliatedBranch(),
	            user.getAffiliatedDistributor(),
	            user.getAffiliatedStore(),
	            user.getRegistrationDate(),
	            user.getPhoneNumber(),
	            user.getSituation(),
	            "/user/details/" + user.getId()
	        ));
	    }

	
	

@Override
public Page<ConnectorDTO> getAllConnectors(Pageable pageable) {
    Page<User> connectors = userDAO.findAllConnectors(pageable);

    return connectors.map(user -> {
        BigDecimal totalDeposit = transactionDAO.getTotalDepositByUserId(user.getId());
        BigDecimal totalWithdrawal = transactionDAO.getTotalWithdrawalByUserId(user.getId());

        BigDecimal bettingSlot = betDAO.getBettingSlotByUserId(user.getId());
        BigDecimal winningSlot = betDAO.getWinningSlotByUserId(user.getId());
        BigDecimal bettingCasino = betDAO.getBettingCasinoByUserId(user.getId());
        BigDecimal winningCasino = betDAO.getWinningCasinoByUserId(user.getId());

        return new ConnectorDTO(
            user.getId(),
            user.getNickname(),
            user.getEmail(),
            user.getAffiliation() != null ? user.getAffiliation().getName() : "No Affiliation",
            user.getMoneyHeld(),
            user.getBeforeRepayment(),
            totalDeposit,
            totalWithdrawal,
            bettingSlot,
            winningSlot,
            bettingCasino,
            winningCasino,
            "SLOT, CASINO",
            "/user/details/" + user.getId()
        );
    });
}
	
	

}
