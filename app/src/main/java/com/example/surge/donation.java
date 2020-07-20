package com.example.surge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class donation extends AppCompatActivity {

    ImageView imageView6,imageView7,imageView8;
    BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        TextView textView28 =(TextView) findViewById(R.id.textView28);
        TextView textView7 =(TextView) findViewById(R.id.textView7);
        TextView textView8 =(TextView) findViewById(R.id.textView8);

        imageView6 = findViewById(R.id.imageView6);//add notices
        imageView7 = findViewById(R.id.imageView7);//places
        imageView8 = findViewById(R.id.imageView8);//contacts

        bottomnav = findViewById(R.id.bottomnav);


        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(donation.this,Notices.class);
                startActivity(intent);

            }
        });

        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(donation.this,DContacts.class);
                startActivity(intent);
            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(donation.this,Notices.class);
                startActivity(intent);
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(donation.this,DContacts.class);
                startActivity(intent);

            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(donation.this,D_location.class);
                startActivity(intent);

            }
        });


        //Bottom Navigation
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.nav_home)
                {
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                if(menuItem.getItemId() == R.id.nav_donations)
                {
                    return true;
                }
                if(menuItem.getItemId() == R.id.nav_safeplaces)
                {
                    Intent intent = new Intent(getApplicationContext(),SafeplacesMain.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                if(menuItem.getItemId() == R.id.nav_uploader)
                {
                    Intent intent = new Intent(getApplicationContext(),uploader.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                if(menuItem.getItemId() == R.id.nav_waterlevel)
                {
                    Intent intent = new Intent(getApplicationContext(),Waterlevel.class);
                    startActivity(intent);
                    finish();
                    return true;
                }


                return false;
            }
        });


    }
}

