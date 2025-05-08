package com.atmbank.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atmbank.dao.AccountDao;
import com.atmbank.dao.TransactionDao;
import com.atmbank.entity.Account;

import jakarta.transaction.Transaction;

@Service
public class AccountService {

    private final AccountDao accountRepo;
    private final TransactionDao transactionRepo;

    public AccountService(AccountDao accountRepo, TransactionDao transactionRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    public Account createAccount(Account account) {
        account.setBalance(0);
        return accountRepo.save(account);
    }

    public Optional<Account> authenticate(Long id, String pin) {
        return accountRepo.findByIdAndPin(id, pin);
    }

    public Optional<Account> deposit(Long id, double amount) {
        return accountRepo.findById(id).map(account -> {
            account.setBalance(account.getBalance() + amount);
            accountRepo.save(account);

            Transaction tx = new  Transaction();
            tx.setAccount(account);
            tx.setType("deposit");
            tx.setAmount(amount);
            tx.setTimestamp(LocalDateTime.now());
            transactionRepo.save(tx);

            return account;
        });
    }

    public Optional<Account> withdraw(Long id, double amount) {
        return accountRepo.findById(id).map(account -> {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                accountRepo.save(account);

                Transaction tx = new  Transaction ();
                tx.setAccount(account);
                tx.setType("withdraw");
                tx.setAmount(amount);
                tx.setTimestamp(LocalDateTime.now());
                transactionRepo.save(tx);

                return account;
            }
            return null;
        });
    }

    public Optional<Double> checkBalance(Long id) {
        return accountRepo.findById(id).map(Account::getBalance);
    }

    public List<Transaction> getTransactionHistory(Long id) {
        return transactionRepo.findByAccountId(id);
    }
}
