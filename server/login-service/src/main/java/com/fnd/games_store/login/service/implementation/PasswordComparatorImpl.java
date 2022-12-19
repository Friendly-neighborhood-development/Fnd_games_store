package com.fnd.games_store.login.service.implementation;

import com.fnd.games_store.login.service.PasswordComparator;
import org.springframework.stereotype.Component;

@Component
public class PasswordComparatorImpl implements PasswordComparator {


    @Override
    public Boolean passwordComparator(String incomingPassword, String actualPassword) {

        return null;
    }
}
