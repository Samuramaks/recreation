package ru.stanok.recreation.config.MyuserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ru.stanok.recreation.entity.Account;
import ru.stanok.recreation.service.AccountServiceRe;


@Component
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private AccountServiceRe userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userService.findByLogin(username);

       return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }

   
    
}
