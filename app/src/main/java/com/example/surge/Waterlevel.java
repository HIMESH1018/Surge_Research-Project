package com.example.surge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Waterlevel extends AppCompatActivity {

    EditText editText11,editText10,editText;
    Button measure,reset,save;
    BottomNavigationView bottomnav;
    DatabaseReference dbRef;
    waterlevlel waterlevl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterlevel);

        editText = findViewById(R.id.editText);     //Time
        editText10 = findViewById(R.id.editText10); //Waterlevel
        editText11 = findViewById(R.id.editText11); //Date
        bottomnav = findViewById(R.id.bottomnav);

        measure = findViewById(R.id.measure); // measure
        reset = findViewById(R.id.reset); // reset & refresh
        save = findViewById(R.id.reset2);// save Data

        waterlevl = new waterlevlel();

        final Thread thread = new Thread() {
            @Override
            public void run() {
                while ((!interrupted())) {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                final Calendar calendar = Calendar.getInstance();
                                final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                                final SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");

                                final String date = simpleDateFormat.format(calendar.getTime());
                                final String time = simpleTimeFormat.format(calendar.getTime());

                                editText11.setText(date);
                                editText.setText(time);

                            }
                        });


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        thread.start();



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
                    return true;
                }

                return false;
            }
        });



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText10.setText("");

            }
        });

        //Adding data to the db
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("WaterLevel");

                    if (TextUtils.isEmpty(editText10.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please Measure the Water Level to add",  Toast.LENGTH_SHORT).show();

                    else{
                        waterlevl.setWaterlevel((editText10.getText().toString().trim())+"%");
                        waterlevl.setTime(editText.getText().toString().trim());
                        waterlevl.setDate(editText11.getText().toString().trim());


                        dbRef.push().setValue(waterlevl);

                        Toast.makeText(getApplicationContext(),"Data Added",Toast.LENGTH_SHORT).show();
                        editText10.setText("");

                    }


            }

        });

        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference redRef = FirebaseDatabase.getInstance().getReference().child("Measure");
                redRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            Toast.makeText(Waterlevel.this, "Loading", Toast.LENGTH_SHORT).show();
                            editText10.setText(dataSnapshot.child("waterlevel").getValue().toString());

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No Measure Data in the Firebase",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }
}
