package com.fnd.games_store.test.service;

import com.fnd.games_store.login.exception.InvalidPasswordException;
import com.fnd.games_store.login.service.PasswordComparator;
import com.fnd.games_store.login.service.implementation.PasswordComparatorImpl;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordComparator_UnitTest {



    private PasswordComparator passwordComparator = new PasswordComparatorImpl();


    @Test
    void compare_ShouldReturnTrueForCorrectPassword(){
        assertThat(passwordComparator.compare("randomPassword","randomPassword")).isTrue();

    }


    @Test
    void compare_ShouldThrowExceptionIfPasswordsAreNotEqual(){
        assertThrows(InvalidPasswordException.class, () -> passwordComparator.compare("RandomPassword","randomPassword"));
    }


}
