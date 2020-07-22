package com.example.surge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class ContactMain extends AppCompatActivity {

    public static final String EXTRA_TEXT="com.example.surge.EXTRA_TEXT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_main);

        final Spinner spinner =findViewById(R.id.spinner);

        Button submit = findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = spinner.getSelectedItem().toString();

                Intent intent = new Intent(ContactMain.this,departmentContacts.class);
                intent.putExtra(EXTRA_TEXT,text);
                startActivity(intent);
            }
        });




    }


}
