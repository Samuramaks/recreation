package ru.stanok.recreation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ru.stanok.recreation.dao.repository.DepartureRepository;
import ru.stanok.recreation.entity.Account;
import ru.stanok.recreation.entity.Departure;


@Service
public class DepartureServiceImp implements DepartureServiceInterface{

    @Autowired
    DepartureRepository departureRepository;

    @Override
    public List<Departure> findAll() {
        return departureRepository.findAll();
    }

    @Override
    public void deleteDepartureById(Long id) {
        departureRepository.deleteById(id);
    }


    @Transactional
    @Override
    public void addDeparture(Departure departure) {
        departureRepository.save(departure);
    }

    @Override
    public Departure finDeparture(Long id) {
        return departureRepository.findById(id).get();
    }

    @Override
    public List<Departure> findByAccount(Account account) {
        return departureRepository.findByAccount(account);
    }
    
}
