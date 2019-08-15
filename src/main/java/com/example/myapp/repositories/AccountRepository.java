package com.example.myapp.repositories;

import com.example.myapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}