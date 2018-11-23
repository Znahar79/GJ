package com.example.nikit.getjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    private class WorkSignIn extends MainActivity {
        public boolean checkPassword(ListOfRegUsers list) {
            boolean t = true;
            EditText edit = (EditText) findViewById(R.id.editText9);
            EditText edit1 = (EditText) findViewById(R.id.editText10);
            //t = edit.getText().toString().equals(edit1.getText().toString());
            if (!edit.getText().toString().equals(edit1.getText().toString())) {
                t = false;
                return t;
            }
            for (int i = 0; i < list.getRegUsers().size(); i++) {
                if (!edit.getText().toString().equals(list.getRegUsers().get(i).getPassword())) {
                    t = false;
                    return t;
                }
            }
            return t;
        }

        public boolean checkEmail(ListOfRegUsers list) {
            boolean t = true;
            EditText edit = (EditText) findViewById(R.id.editText8);
            for (int i = 0; i < list.getRegUsers().size(); i++) {
                if (!edit.getText().toString().equals(list.getRegUsers().get(i).getEmail())) {
                    t = false;
                    return t;
                }
            }
            return t;
        }

        public boolean checkPhone(ListOfRegUsers list) {
            boolean t = true;
            EditText edit = (EditText) findViewById(R.id.editText7);
            for (int i = 0; i < list.getRegUsers().size(); i++) {
                if (!edit.getText().toString().equals(list.getRegUsers().get(i).getPhone())) {
                    t = false;
                    return t;
                }
            }
            return t;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signin);
        }

        public void onClickGoLogin(View view) {
            //boolean t = true;
            boolean c1 = checkEmail(dataBase);
            boolean c2 = checkPassword(dataBase);
            boolean c3 = checkPhone(dataBase);
            boolean t = c1 & c2;
            t = t & c3;
            if (t == true) {
                EditText edit1 = (EditText) findViewById(R.id.editText3);//имя
                EditText edit2 = (EditText) findViewById(R.id.editText4);//Фамилия
                EditText edit3 = (EditText) findViewById(R.id.editText7);//Телефон
                EditText edit4 = (EditText) findViewById(R.id.editText8);//Email
                EditText edit5 = (EditText) findViewById(R.id.editText9);//Пароль
                dataBase.addUser(new User(edit1.getText().toString(), edit2.getText().toString(),
                        edit5.getText().toString(), edit4.getText().toString(),
                        edit3.getText().toString(), "New One",
                        User.UserType.SimpleUser,(float)0.0));
                Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Неверные введённые данные или они уже заняты", Toast.LENGTH_LONG).show();
            }
        }
    }

}
