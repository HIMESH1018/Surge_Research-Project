package com.example.surge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Waterlevel extends AppCompatActivity {

    EditText editText11,editText10,editText;
    Button measure,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterlevel);

        editText = findViewById(R.id.editText);     //Time
        editText10 = findViewById(R.id.editText10); //Waterlevel
        editText11 = findViewById(R.id.editText11); //Date


        measure = findViewById(R.id.measure); // measure
        reset = findViewById(R.id.reset); // reset & refresh


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






        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText10.setText("");

            }
        });

    }
}
