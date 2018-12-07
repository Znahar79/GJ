package com.example.nikit.getjob;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Before
    public void setUp() throws Exception {
        ListOfRegUsers dataBaseTest = new ListOfRegUsers();
        ListOfAllVacancys dataBaseVacancysTest = new ListOfAllVacancys();
        //Linking UserCreator to our dataBase
        UserCreator creator=new UserCreator(dataBaseTest,dataBaseVacancysTest);
        User currentUser = new User();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkEmail() {
        
    }

    @Test
    public void checkPassword() {
    }

    @Test
    public void onCreate() {
    }

    @Test
    public void onClickSignin() {
    }

    @Test
    public void onClickLogin() {
    }
}