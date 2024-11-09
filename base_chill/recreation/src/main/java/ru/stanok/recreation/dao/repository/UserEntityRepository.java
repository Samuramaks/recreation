package ru.stanok.recreation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.stanok.recreation.entity.Account;

public interface UserEntityRepository extends JpaRepository<Account, Long>{
    Account findByLogin(String login);
    
}
