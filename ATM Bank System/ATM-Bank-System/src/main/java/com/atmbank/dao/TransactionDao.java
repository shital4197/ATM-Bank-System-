package com.atmbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transaction;

public interface TransactionDao  extends JpaRepository<Transaction, Long>{
	
	 List<Transaction> findByAccountId(Long accountId);
	 
}
	   
	