package com.example.surge;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContactMain extends AppCompatActivity {

    public static final String EXTRA_TEXT="com.example.surge.EXTRA_TEXT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_main);

        final Spinner spinner =findViewById(R.id.spinner);

        Button submit = findViewById(R.id.submit);
        BottomNavigationView bottomnav = findViewById(R.id.bottomnav);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = spinner.getSelectedItem().toString();

                Intent intent = new Intent(ContactMain.this,departmentContacts.class);
                intent.putExtra(EXTRA_TEXT,text);
                startActivity(intent);
            }
        });

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.nav_home)
                {
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);
                    return true;
                }
                if(menuItem.getItemId() == R.id.nav_donations)
                {
                    Intent intent = new Intent(getApplicationContext(),donation.class);
                    overridePendingTransition(0,0);
                    startActivity(intent);
                    return true;
                }
                if(menuItem.getItemId() == R.id.nav_safeplaces)
                {
                    Intent intent = new Intent(getApplicationContext(),SafeplacesMain.class);
                    overridePendingTransition(0,0);
                    startActivity(intent);
                    return true;
                }
                if(menuItem.getItemId() == R.id.nav_uploader)
                {
                    Intent intent = new Intent(getApplicationContext(),uploader.class);
                    overridePendingTransition(0,0);
                    startActivity(intent);
                    return true;
                }
                if(menuItem.getItemId() == R.id.nav_waterlevel)
                {
                    Intent intent = new Intent(getApplicationContext(),Waterlevel.class);
                    overridePendingTransition(0,0);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });


    }


}
