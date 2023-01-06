package com.fnd.games_store.test.repository;

import com.fnd.games_store.login.entity.Account;
import com.fnd.games_store.login.entity.Authority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositoryTestCommons {


   protected Account createProperAdminAccount(String username, CharSequence date){

        Account properAdminAccount = new Account();
        properAdminAccount.setId("1");
        properAdminAccount.setUsername(username);
        properAdminAccount.setPassword("$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6");
        properAdminAccount.setEmail("admin@gmail.com");
        properAdminAccount.setExpirationDate(LocalDate.parse(date.toString()));
        properAdminAccount.setIsAccountEnabled(true);
        properAdminAccount.setCredentialsExpirationDate(LocalDate.parse(date.toString()));
        properAdminAccount.setIsAccountNonLocked(true);



        List<Authority> adminGrantedAuthorities = new ArrayList<>();
        Authority adminAuthority = new Authority("1", "super_user");
        Authority staffAuthority = new Authority("2", "staff_user");
        Authority regularAuthority = new Authority("3", "regular_user");

        adminGrantedAuthorities.add(adminAuthority);
        adminGrantedAuthorities.add(staffAuthority);
        adminGrantedAuthorities.add(regularAuthority);

        properAdminAccount.setAuthorities(adminGrantedAuthorities);

        return properAdminAccount;
    }


}
