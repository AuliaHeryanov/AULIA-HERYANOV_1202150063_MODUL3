package com.example.auliaheryanov.auliaheryanov_1202150063_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private String mUsername;
    private String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        EditText username = (EditText) findViewById(R.id.editUsername);
        mUsername = username.getText().toString();
        EditText password = (EditText) findViewById(R.id.editPassword);
        mPassword = password.getText().toString();

        if (mUsername.equals("EAD")) {
            if (mPassword.equals("MOBILE")) {
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Username dan Password anda tidak cocok, coba lagi", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Username dan Password anda tidak cocok, coba lagi", Toast.LENGTH_SHORT).show();
        }

    }
}
