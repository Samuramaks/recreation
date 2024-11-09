package ru.stanok.recreation.service;

import java.util.List;

import ru.stanok.recreation.entity.Account;
import ru.stanok.recreation.entity.Departure;

public interface DepartureServiceInterface {
    List<Departure> findAll();
    void deleteDepartureById(Long id);
    void addDeparture(Departure departure);
    Departure finDeparture(Long id);
    List<Departure> findByAccount(Account account);
}
