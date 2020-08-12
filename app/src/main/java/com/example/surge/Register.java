package com.example.surge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText username,username2,password,password2,number;
    Button signup;
    DatabaseReference dbref;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestore;
    String userID;

    User user, user1;
    private static final String TAG = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);   //email
        username2 = findViewById(R.id.username2); //username
        password = findViewById(R.id.password);   // Re-enter pass
        password2 = findViewById(R.id.password2); // password
        number = findViewById(R.id.number);       //mobile-number

        signup = findViewById(R.id.signup);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = username.getText().toString().trim();
                String passwordcheck = password2.getText().toString();

                String reenterpass  = password.getText().toString();
                final String name   = username2.getText().toString();
                final String phone  = number.getText().toString();


                if(TextUtils.isEmpty(name)){
                    username2.setError("Username is Required.");
                    return;
                }

                if(TextUtils.isEmpty(email)) {
                    username.setError("Email is Required.");
                    return;
                }
                if(email.contains("@")) {

                }
                else {
                    username.setError("Email does not contains valid charracters");
                }

                if(TextUtils.isEmpty(passwordcheck)){
                    password2.setError("Password is Required.");
                    return;
                }

                if(TextUtils.isEmpty(reenterpass)){
                        password.setError("Password is Required.");
                        return;
                }

                if (passwordcheck.equals(reenterpass)) {

                }
                else{
                    password.setError("Password Does not match");
                    return;
                }


                if(TextUtils.isEmpty(phone)) {
                        number.setError("Mobile number is Required.");
                        return;

                }


                else {

                    firebaseAuth.createUserWithEmailAndPassword(email,passwordcheck).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                FirebaseUser fuser = firebaseAuth.getCurrentUser();
                                fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                        Toast.makeText(Register.this, "Email Verification Sent", Toast.LENGTH_SHORT).show();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(Register.this, "Email Verification error", Toast.LENGTH_SHORT).show();

                                    }
                                });

                                Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                                userID = firebaseAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = firestore.collection("users").document(userID);

                                Map<String,Object> user = new HashMap<>();
                                user.put("fName",name);
                                user.put("email",email);
                                user.put("phone",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });

                            }else{
                                Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }


                        }
                    });

            }
        }






    });


    }

}