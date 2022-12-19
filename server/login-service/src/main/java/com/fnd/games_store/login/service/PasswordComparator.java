package com.fnd.games_store.login.service;

public interface PasswordComparator {

    public Boolean passwordComparator(String incomingPassword, String actualPassword);

}
