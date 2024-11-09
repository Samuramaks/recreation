package ru.stanok.recreation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import ru.stanok.recreation.config.AuthRequest;
import ru.stanok.recreation.config.AuthResponse;
import ru.stanok.recreation.config.JwtProvider;
import ru.stanok.recreation.dto.AccountDTO;
import ru.stanok.recreation.dto.RegistatrationRequest;
import ru.stanok.recreation.entity.Account;
import ru.stanok.recreation.service.AccountServiceRe;

@Log4j2
@RestController
public class ControllerAuthorization {
    @Autowired
    private AccountServiceRe accountServiceRe;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistatrationRequest registartionRequest) {
            log.info("Registering user with login: " + registartionRequest.getLogin());
            Account account = new Account();
            account.setPassword(registartionRequest.getPassword());
            account.setLogin(registartionRequest.getLogin());
            account.setFirstName(registartionRequest.getFirstName());
            account.setLastName(registartionRequest.getLastName());
            accountServiceRe.saveUser(account);
            log.info("User registered successfully: " + account.getLogin());
            return "OK";
    }






    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        Account account = accountServiceRe.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(account.getLogin());
        return new AuthResponse(token);
    }


    @GetMapping("/user")
    public List<AccountDTO> getAccounts() {
        return accountServiceRe.findAll().stream().map(AccountDTO::from).collect(Collectors.toList());
    }

    
    
    
    
    
}
