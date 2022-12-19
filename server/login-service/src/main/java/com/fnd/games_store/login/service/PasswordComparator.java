package com.fnd.games_store.login.service;

public interface PasswordComparator {

    public Boolean compare(String incomingPassword, String actualPassword);

}
