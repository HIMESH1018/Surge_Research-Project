package com.example.surge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPass extends AppCompatActivity {

    EditText email;
    Button button2;
    private final String CHANNEL_ID = "password";
    private final int NOTIFICATION_ID = 234;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        email = findViewById(R.id.email);
        button2 = findViewById(R.id.button2);

        firebaseAuth = FirebaseAuth.getInstance();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                String sendemail = email.getText().toString().trim();

                if (sendemail.equals("")) {
                    Toast.makeText(ForgetPass.this, "Please Enter your Email", Toast.LENGTH_SHORT).show();
                } else {

                    firebaseAuth.sendPasswordResetEmail(sendemail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ForgetPass.this, "Password Reset Email Sent", Toast.LENGTH_SHORT).show();
                                finish();
                                notficationcall(view);
                                startActivity(new Intent(ForgetPass.this, LoginActivity.class));

                            } else {
                                String error = task.getException().getMessage();
                                Toast.makeText(ForgetPass.this, "Error in sending the password reset", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    public void notficationcall(View view) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setContentTitle("Notification from Surge ");
        builder.setContentText("Password Reset Email has been sent");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationmanagercompact = NotificationManagerCompat.from(this);
        notificationmanagercompact.notify(NOTIFICATION_ID, builder.build());


    }
}
