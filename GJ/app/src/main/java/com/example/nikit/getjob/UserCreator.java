package com.example.nikit.getjob;

public class UserCreator {
    private final ListOfRegUsers db;
    private final ListOfAllVacancys dbv;
    //Each working class attaches itself to specific database instance. Therefore, you need to pass that instance through the constructor and save it for later job
    public UserCreator(ListOfRegUsers operationalDb,ListOfAllVacancys operationalDbv) {
        this.db = operationalDb;
        this.dbv = operationalDbv;
    }

    public void DeafaultData() {
        db.addUser(new User("default","default","admin",
                "dasd@yandex.ru", "+7***","New one",User.UserType.SimpleUser,0));
    }
}
