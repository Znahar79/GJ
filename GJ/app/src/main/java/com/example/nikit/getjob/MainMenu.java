package com.example.nikit.getjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    //DataBases initialize
    static ListOfRegUsers dataBase = new ListOfRegUsers();
    static ListOfAllVacancys dataBaseVacancys = new ListOfAllVacancys();
    //Linking UserCreator to our dataBase
    static UserCreator creator=new UserCreator(dataBase);
    static User currentUser = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    //Method activates when click on button "Авторизация"
    public void onClickAuthorization(View view) {
        Intent intent = new Intent(MainMenu.this, MainActivity.class);
        startActivity(intent);
    }
}
