package com.fnd.games_store.login.service.implementation;

import com.fnd.games_store.login.exception.InvalidPasswordException;
import com.fnd.games_store.login.service.PasswordComparator;
import org.springframework.stereotype.Component;

@Component
public class PasswordComparatorImpl implements PasswordComparator {


    @Override
    public Boolean compare(String incomingPassword, String actualPassword) {

        if (incomingPassword.equals(actualPassword)){
            return true;
        } else throw new InvalidPasswordException("invalid password");

    }
}
