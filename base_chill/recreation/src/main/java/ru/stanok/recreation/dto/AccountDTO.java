package ru.stanok.recreation.dto;

import lombok.Data;
import ru.stanok.recreation.entity.Account;

@Data
public class AccountDTO {
    private long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;

    public static AccountDTO from(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setLogin(account.getLogin());
        accountDTO.setPassword(account.getPassword());
        accountDTO.setFirstName(account.getFirstName());
        accountDTO.setLastName(account.getLastName());

        return accountDTO;
    }
}
