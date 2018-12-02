package com.example.nikit.getjob;

import java.util.ArrayList;

public class ListOfRegUsers {
    private  ArrayList<User> regUsers = new ArrayList<>();
    //Way to read the stored data
    public ArrayList<User> getRegUsers() {
        return regUsers;
    }

    //Way to add new data
    public void addUser(User newUser) {
        regUsers.add(newUser);
    }
}
