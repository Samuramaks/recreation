package ru.stanok.recreation.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.stanok.recreation.entity.Account;
import ru.stanok.recreation.entity.Departure;


@Repository
public interface DepartureRepository extends JpaRepository<Departure, Long>{
    List<Departure> findByAccount(Account account);
}
