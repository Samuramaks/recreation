package ru.stanok.recreation.entity;


import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "departure_table")
public class Departure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate dateDeparture;

    @Column
    private LocalDate dateArrival;

    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    } 

    public void setDateDeparture(LocalDate dateDeparture){
        this.dateDeparture = dateDeparture;
    }

    public LocalDate getDateDeparture(){
        return this.dateDeparture;
    }

    public void setDateArrival(LocalDate dateArrival){
        this.dateArrival = dateArrival;
    }

    public LocalDate getDateArrival(){
        return this.dateArrival;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    
}
