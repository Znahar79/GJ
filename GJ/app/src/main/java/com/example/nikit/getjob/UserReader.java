package com.example.nikit.getjob;

public class UserReader {
    private final ListOfRegUsers db;

    //Each working class attaches itself to specific database instance. Therefore, you need to pass that instance through the constructor and save it for later job
    public UserReader(ListOfRegUsers operationalDb) {
        this.db = operationalDb;
    }

    public void doSomeWork() {
        for (User e : db.getRegUsers()) {

        }
    }
}
