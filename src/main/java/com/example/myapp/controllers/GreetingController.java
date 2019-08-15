package com.example.myapp.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.myapp.model.Account;
import com.example.myapp.model.Greeting;
import com.example.myapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins="https://snind.herokuapp.com")
@RestController
public class GreetingController {
    @Autowired
    AccountService service;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    @PostMapping(path = "/account", consumes = "application/json")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        service.createAccount(account);
        return new ResponseEntity<String>("Acont created successfuly", HttpStatus.CREATED);
    }

    @RequestMapping("/list")
    public List<Account>  listAccount() {
        return service.getAll();
    }
}
