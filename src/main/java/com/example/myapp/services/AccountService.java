package com.example.myapp.services;

import com.example.myapp.model.Account;
import com.example.myapp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    public List<Account> getAll() {
        return repository.findAll();
    }

    public void createAccount(Account account) {
        repository.save(account);
    }

}
