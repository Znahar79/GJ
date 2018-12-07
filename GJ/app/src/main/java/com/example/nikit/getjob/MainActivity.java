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


    protected boolean checkEmail(ListOfRegUsers list){
        boolean t = false;
        EditText edit = (EditText)findViewById(R.id.editText);
        for (int i = 0; i<list.getRegUsers().size(); i++){
            if(edit.getText().toString().equals(list.getRegUsers().get(i).getEmail())){
                t = true;
                return t;
            }
        }
        return t;
    }
    protected boolean checkPassword(ListOfRegUsers list){
        boolean t = false;
        EditText edit = (EditText)findViewById(R.id.editText2);
        for (int i = 0; i<list.getRegUsers().size(); i++){
            if(edit.getText().toString().equals(list.getRegUsers().get(i).getPassword())){
                t = true;
                return t;
            }
        }
        return t;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainMenu.creator.DeafaultData();
    }

    //Method activates when click on button "РЕГИСТРАЦИЯ"
    public void onClickSignin(View view) {
            Intent intent = new Intent(MainActivity.this, SigninActivity.class);
            startActivity(intent);
    }
    //Method activates when click on button "ВХОД"
    public void onClickLogin(View view) {
        EditText edit = (EditText)findViewById(R.id.editText2);
        EditText editMail = (EditText)findViewById(R.id.editText);
        boolean lastCheck = false;
        boolean c1 = checkEmail(MainMenu.dataBase);
        boolean c2 = checkPassword(MainMenu.dataBase);
        boolean t = c1 & c2;
        if(t == true) {
            User old;
            for(int i = 0; i < MainMenu.dataBase.getRegUsers().size();i++){
                if(edit.getText().toString().equals(MainMenu.dataBase.getRegUsers().get(i).getPassword()) &&
                        editMail.getText().toString().equals(MainMenu.dataBase.getRegUsers().get(i).getEmail())){
                    old = new User(MainMenu.dataBase.getRegUsers().get(i).getName(),MainMenu.dataBase.getRegUsers().get(i).getSurname(),
                            MainMenu.dataBase.getRegUsers().get(i).getPassword(),MainMenu.dataBase.getRegUsers().get(i).getEmail(),
                            MainMenu.dataBase.getRegUsers().get(i).getPhone(),MainMenu.dataBase.getRegUsers().get(i).getTag(),
                            User.UserType.SimpleUser, MainMenu.dataBase.getRegUsers().get(i).getRating());
                    MainMenu.currentUser = old;
                    lastCheck = true;
                    break;
                }
            }
            if(lastCheck == false){
                Toast.makeText(getApplicationContext(), "Неверный email или пароль", Toast.LENGTH_LONG).show();
            }
            else{
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Неверный email или пароль", Toast.LENGTH_LONG).show();
        }
    }
}
