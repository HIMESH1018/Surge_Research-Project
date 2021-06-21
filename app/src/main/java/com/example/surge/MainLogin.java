package com.example.surge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainLogin extends AppCompatActivity {

    Button login;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


        login = findViewById(R.id.login);         // Register
        textView3 = findViewById(R.id.textView3); //login


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLogin.this,Register.class);
                startActivity(intent);

            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLogin.this,LoginActivity.class);
                startActivity(intent);

            }
        });


    }
}
