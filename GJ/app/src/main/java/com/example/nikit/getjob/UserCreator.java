package com.example.nikit.getjob;

public class UserCreator {
    private final ListOfRegUsers db;

    //Each working class attaches itself to specific database instance. Therefore, you need to pass that instance through the constructor and save it for later job
    public UserCreator(ListOfRegUsers operationalDb) {
        this.db = operationalDb;
    }

    public void DeafaultData() {
        db.addUser(new User("default","default","admin",
                "dasd@yandex.ru", "+7***","New one",User.UserType.SimpleUser,0));
    }
}
