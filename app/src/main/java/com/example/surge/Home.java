package com.example.surge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.ExifInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {

    ImageView safeplaces,donations,uploader,waterlevel;
    ImageButton imageButton,imageButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

          uploader =  (ImageView) findViewById(R.id.uploader);//Uploader
          safeplaces =  (ImageView) findViewById(R.id.safeplaces);//Safe_places
          donations =  (ImageView) findViewById(R.id.donations);//Donation
          waterlevel = (ImageView) findViewById(R.id.waterlevel);//Water_Level

          imageButton = (ImageButton) findViewById(R.id.imageButton);    //Account
          imageButton2 = (ImageButton) findViewById(R.id.imageButton2); //Exit


        safeplaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Home.this,SafeplacesMain.class);
                startActivity(intent);

            }
        });


        donations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Home.this,donation.class);
                startActivity(intent);

            }
        });

        uploader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Home.this,uploader.class);
                startActivity(intent);

            }
        });

        waterlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Home.this,Waterlevel.class);
                startActivity(intent);

            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Home.this,Profile_Account.class);
                startActivity(intent);


            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Home.this,MainLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
