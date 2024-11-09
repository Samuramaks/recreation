package ru.stanok.recreation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import ru.stanok.recreation.dto.DepartureDTO;
import ru.stanok.recreation.entity.Account;
import ru.stanok.recreation.entity.Departure;
import ru.stanok.recreation.service.AccountServiceRe;
import ru.stanok.recreation.service.DepartureServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Log4j2
@RestController
@RequestMapping("/departure")
public class ControllerDeparture {
    
    @Autowired
    private DepartureServiceInterface departureServiceInterface;

    @Autowired
    private AccountServiceRe accountServiceRe;


    @Autowired
    

    @GetMapping("/all")
    public List<DepartureDTO> getAllDeparture() {
        return departureServiceInterface.findAll().stream()
        .map(DepartureDTO::from)
        .collect(Collectors.toList());
    }

    @PostMapping("/append")
    public ResponseEntity<Departure> appendUserDeparture(@RequestParam Long id) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Account account = accountServiceRe.findByLogin(authentication.getName());
        Departure departure = departureServiceInterface.finDeparture(id);
        departure.setAccount(account);
        departureServiceInterface.addDeparture(departure);
        
        
        
        return ResponseEntity.ok().build();
    }

    @GetMapping("/watch")
    public List<DepartureDTO> getAllUserDepartures() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountServiceRe.findByLogin(authentication.getName());
        List<Departure> departures = departureServiceInterface.findByAccount(account);
       
        return departures.stream()
        .map(DepartureDTO::from)
        .collect(Collectors.toList());
    }
    
    
    
}
