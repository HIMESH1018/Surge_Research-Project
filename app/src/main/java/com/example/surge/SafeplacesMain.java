package com.example.surge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SafeplacesMain extends AppCompatActivity {

    Button contact,map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safeplaces_main);

        map = findViewById(R.id.map);
        contact = findViewById(R.id.contact);


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SafeplacesMain.this,safeplaces.class);
                startActivity(intent);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SafeplacesMain.this,ContactMain.class);
                startActivity(intent);

            }
        });


    }
}
