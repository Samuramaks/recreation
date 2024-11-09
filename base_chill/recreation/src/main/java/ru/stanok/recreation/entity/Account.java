package ru.stanok.recreation.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "account_table")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column
    private RoleEntityEnum roleEntityEnum;

    @OneToMany(mappedBy = "account")
    private List<Departure> departures;


    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }


    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return this.login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setRoleEntityEnum(RoleEntityEnum roleEntityEnum){
        this.roleEntityEnum = roleEntityEnum;
    }

    public RoleEntityEnum getRoleEntityEnum(){
        return this.roleEntityEnum;
    }

    public List<Departure> getDepartures() {
        return this.departures;
    }

    public void setDepartures(List<Departure> departures) {
        this.departures = departures;
    }


}
