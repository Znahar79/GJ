package com.example.nikit.getjob;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//import com.example.nikit.getjob.ListOfRegUsers;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //DataBase initialize
    ListOfRegUsers dataBase = new ListOfRegUsers();
    //Linking UserCreator to our dataBase
    UserCreator creator=new UserCreator(dataBase);
    User currentUser = new User();

    public boolean checkEmail(ListOfRegUsers list){
        boolean t = true;
        EditText edit = (EditText)findViewById(R.id.editText);
        for (int i = 0; i<list.getRegUsers().size(); i++){
            if(edit.getText().toString().equals(list.getRegUsers().get(i).getEmail())){
                t = false;
                return t;
            }
        }
        return t;
    }
    public boolean checkPassword(ListOfRegUsers list){
        boolean t = true;
        EditText edit = (EditText)findViewById(R.id.editText2);
        for (int i = 0; i<list.getRegUsers().size(); i++){
            if(edit.getText().toString().equals(list.getRegUsers().get(i).getPassword())){
                t = false;
                return t;
            }
        }
        return t;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creator.DeafaultData();
    }

    //Method activates when click on button "РЕГИСТРАЦИЯ"
    public void onClickSignin(View view) {
            Intent intent = new Intent(MainActivity.this, SigninActivity.class);
            startActivity(intent);
    }
    //Method activates when click on button "ВХОД"
    public void onClickLogin(View view) {
        EditText edit = (EditText)findViewById(R.id.editText2);
        boolean c1 = checkEmail(dataBase);
        boolean c2 = checkPassword(dataBase);
        boolean t = c1 & c2;
        if(t == true) {
            //User old = ;
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Неверный email или пароль", Toast.LENGTH_LONG).show();
        }
    }
}
