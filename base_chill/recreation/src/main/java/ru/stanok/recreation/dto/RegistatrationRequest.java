package ru.stanok.recreation.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import ru.stanok.recreation.entity.Account;

@Data
public class RegistatrationRequest {
    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

     
    private String firstName;

    
    private String lastName;



    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFirstName() {return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() {return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Account toAccount(){
        Account account = new Account();
        account.setLogin(login);
        account.setPassword(password);
        account.setFirstName(firstName);
        account.setLastName(lastName);

        return account;
    }

}
