package com.example.nikit.getjob;

import java.util.ArrayList;

public class ListOfAllVacancys {
    private ArrayList<Vacancy> Vacancys = new ArrayList<>();
    //Way to read the stored data
    public ArrayList<Vacancy> getAllVacancys() {
        return Vacancys;
    }

    //Way to add new data
    public void addUser(Vacancy newVacancy) {
        Vacancys.add(newVacancy);
    }
}
