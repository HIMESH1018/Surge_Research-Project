package com.example.surge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Notices extends AppCompatActivity {

    EditText editText2,editText3,editText4;
    TextView nottext;
    Button login;
    DatabaseReference dbRef,redRef;
    Notice not1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);

        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        nottext = findViewById(R.id.nottext);

        login = findViewById(R.id.login);

        not1 = new Notice();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Requests");
        redRef = FirebaseDatabase.getInstance().getReference().child("Notice");

        //To Display Donation notices
        redRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren())
                {
                    nottext.setText(dataSnapshot.child("notice").getValue().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(), "No Notice To Display", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //To submit Donation Requests
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (TextUtils.isEmpty(editText2.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_SHORT).show();

                else if (TextUtils.isEmpty(editText3.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();

                else if (TextUtils.isEmpty(editText4.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please Enter Description", Toast.LENGTH_SHORT).show();


                else {
                    not1.setName(editText2.getText().toString().trim());
                    not1.setNumber(Integer.parseInt(editText3.getText().toString().trim()));
                    not1.setDescription(editText4.getText().toString().trim());

                    dbRef.push().setValue(not1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(), "Donation Request Added", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Notices.this,Home.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Something Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

    }


}
