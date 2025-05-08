package com.atmbank.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atmbank.entity.Account;

public interface AccountDao extends JpaRepository<Account, Long>{
	
	Optional<Account> findByIdAndPin(Long id, String pin);
}
	
	

	
	  
