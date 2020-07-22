package com.example.surge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DContacts extends AppCompatActivity {

    DatabaseReference redRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_contacts);

        //For Retrive Phone numbers
        final TextView textView20 =(TextView) findViewById(R.id.textView20);
        final TextView textView27 =(TextView) findViewById(R.id.textView27);
        final TextView textView29 =(TextView) findViewById(R.id.textView29);
        final TextView textView31 =(TextView) findViewById(R.id.textView31);
        final TextView textView30 =(TextView) findViewById(R.id.textView30);

        //For Retrive Names
        final TextView editText5 =(TextView) findViewById(R.id.editText5);  //textview20
        final TextView editText17 =(TextView) findViewById(R.id.editText17); //textview27
        final TextView editText6 =(TextView) findViewById(R.id.editText6);  //textview29
        final TextView editText8 =(TextView) findViewById(R.id.editText8);  //textview31
        final TextView editText7 =(TextView) findViewById(R.id.editText7);  //textview30


        Button button4 = (Button)findViewById(R.id.button4); //textview20
        Button button5 = (Button)findViewById(R.id.button5); //textview27
        Button button10 = (Button)findViewById(R.id.button10); //textview29
        Button button12 = (Button)findViewById(R.id.button12); //textview31
        Button button13 = (Button)findViewById(R.id.button13); //textview30

        BottomNavigationView bottomnav = (BottomNavigationView) findViewById(R.id.bottomnav);



        redRef = FirebaseDatabase.getInstance().getReference().child("Contacts");
        redRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.hasChildren()){
                    editText5.setText(dataSnapshot.child("Name").getValue().toString());
                    textView20.setText(dataSnapshot.child("Number").getValue().toString());

                    editText17.setText(dataSnapshot.child("Name1").getValue().toString());
                    textView27.setText(dataSnapshot.child("Number1").getValue().toString());

                    editText6.setText(dataSnapshot.child("Name2").getValue().toString());
                    textView29.setText(dataSnapshot.child("Number2").getValue().toString());

                    editText8.setText(dataSnapshot.child("Name3").getValue().toString());
                    textView31.setText(dataSnapshot.child("Number3").getValue().toString());

                    editText7.setText(dataSnapshot.child("Name4").getValue().toString());
                    textView30.setText(dataSnapshot.child("Number4").getValue().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Source to Display", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = textView20.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    Toast.makeText(getApplicationContext(), "Connecting the call", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = textView27.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    Toast.makeText(getApplicationContext(), "Connecting the call", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = textView29.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    Toast.makeText(getApplicationContext(), "Connecting the call", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = textView31.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    Toast.makeText(getApplicationContext(), "Connecting the call", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = textView30.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    Toast.makeText(getApplicationContext(), "Connecting the call", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

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
