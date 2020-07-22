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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.surge.ContactMain.EXTRA_TEXT;

public class DepartmentContact_Hospital extends AppCompatActivity {
    BottomNavigationView bottomnav,upernav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_contact__hospital);

        Intent intent = getIntent();
        final String text = intent.getStringExtra(ContactMain.EXTRA_TEXT);




        //Declare Province Variables
        String WP = "Western";
        String NW = "North Western";
        String uva = "Uva";
        String SG = "Sabaragamuwa";
        String CP = "Central";
        String NC = "North Central";
        String EP = "Eastern";
        String NP = "Northern";
        String SP = "Southern";

        //BottomNavigationViews

        bottomnav = findViewById(R.id.bottomnav);//Yellow Bottomnav
        upernav = findViewById(R.id.upernav);//Brown Uppernav

        //Button Images for Phone icon
        Button button3 = (Button) findViewById(R.id.button3);//Textview25
        Button button6 = (Button) findViewById(R.id.button6); //Textview26
        Button button8 = (Button) findViewById(R.id.button8);//Textview23
        Button button9 = (Button) findViewById(R.id.button9);//Textview22
        Button button7 = (Button) findViewById(R.id.button7);//Textview24

        //TextView For Division names
        TextView textView15 = (TextView) findViewById(R.id.textView15);//textview25
        TextView textView16 = (TextView) findViewById(R.id.textView16);//textview26
        TextView textView17 = (TextView) findViewById(R.id.textView17);//textview23
        TextView textView18 = (TextView) findViewById(R.id.textView18);//textview24
        TextView textView19 = (TextView) findViewById(R.id.textView19);//textview22

        //TextView for Division number
        final TextView textView21 = (TextView) findViewById(R.id.textView21);//Text Header
        final TextView textView22 = (TextView) findViewById(R.id.textView22);
        final TextView textView23 = (TextView) findViewById(R.id.textView23);
        final TextView textView24 = (TextView) findViewById(R.id.textView24);
        final TextView textView25 = (TextView) findViewById(R.id.textView25);
        final TextView textView26 = (TextView) findViewById(R.id.textView26);


        textView21.setText(text);//Get the Spinner Value to Textbox

        //Western Province
        if (text.equals(WP)) {

            textView25.setText("0112691111");//number
            textView15.setText("Colombo-General");

            textView23.setText("0332222261");//number
            textView17.setText("Gampaha-General");

            textView24.setText("0113818078");//number
            textView18.setText("Navy-General");

            textView22.setText("0312222261");
            textView19.setText("Negombo-General");

            textView26.setText("0382223261");//number
            textView16.setText("Panadura-Base");

        }

        //North Western Province
        else if (text.equals(NW)) {
            textView25.setText("0372222261");//number
            textView15.setText("Kurunegala-Teaching");

            textView23.setText("0372281261");//number
            textView17.setText("Kuliyapitiya-Teaching");

            textView24.setText("0372260261");//number
            textView18.setText("Nikaweratiya-Base");

            textView22.setText("0322265261");
            textView19.setText("Puttalam-Base");

            textView26.setText("0322223261");//number
            textView16.setText("Chilaw-General");
        }

        //Central Province
        else if (text.equals(CP)) {
            textView25.setText("0662222261");//number
            textView15.setText("Matale-General");

            textView23.setText("0522222261");//number
            textView17.setText("Nuwaraeliya-General");

            textView24.setText("0542222261");//number
            textView18.setText("Nawalapitiya_General");

            textView22.setText("0812222261");
            textView19.setText("Kandy-General");

            textView26.setText("0812402461");//number
            textView16.setText("Udadumbara_General");
        }

        //Northern Province
        else if (text.equals(NP)) {
            textView25.setText("0232222261");//number
            textView15.setText("Mannar-General");

            textView23.setText("0212223348");//number
            textView17.setText("Jaffna-Base");

            textView24.setText("0242222761");//number
            textView18.setText("Vavuniya-General");

            textView22.setText("0212285329");
            textView19.setText("Kilinochchi-General");

            textView26.setText("0212061412");//number
            textView16.setText("Umllativu-General");
        }

        //Uva Province
        else if (text.equals(uva)) {
            textView25.setText("0552222261");//number
            textView15.setText("Badulla-General");

            textView23.setText("0572229060");//number
            textView17.setText("Diyathalawa-Base");

            textView24.setText("0552276261");//number
            textView18.setText("Monaragala-General");

            textView22.setText("0472234061");
            textView19.setText("Thanamalwila-Divisional");

            textView26.setText("0572274861");//number
            textView16.setText("Wellawaya-Base");
        }

        //Southern Province
        else if (text.equals(SP)) {
            textView25.setText("0412222261");//number
            textView15.setText("Mathara-General");

            textView23.setText("0912232267");//number
            textView17.setText("Galle-Teaching");

            textView24.setText("0912291261");//number
            textView18.setText("Elpitiya-Base");

            textView22.setText("0472240261");
            textView19.setText("Tangalle-Base");

            textView26.setText("0472220261");//number
            textView16.setText("Hambanthota-General");
        }

        //Sabaragamua Province
        else if (text.equals(SG)) {
            textView25.setText("0452222261");//number
            textView15.setText("Rathnapura-General");

            textView23.setText("0352222261");//number
            textView17.setText("Kegalle-Teaching");

            textView24.setText("0452279261");//number
            textView18.setText("Wathupitiya-General");

            textView22.setText("0472230261");
            textView19.setText("Embilipitiya-General");

            textView26.setText("0452287261");//number
            textView16.setText("Balangoda-Base");
        }

        //North Central Province
        else if (text.equals(NC)) {
            textView25.setText("0252222261");//number
            textView15.setText("Anuradhapura-Teaching");

            textView23.setText("0272222261");//number
            textView17.setText("Polonnaruwa-General");

            textView24.setText("0272223079");//number
            textView18.setText("Aranaganwila-Devisional");

            textView22.setText("0252278461");
            textView19.setText("Horowpathana-Divisional");

            textView26.setText("0252245661");//number
            textView16.setText("Medawachchiya-Divisional");
        }

        //Eastern Province
        else if (text.equals(EP)) {
            textView25.setText("0652222261");//number
            textView15.setText("Batticaloa-Teaching");

            textView23.setText("0632222261");//number
            textView17.setText("Ampara-General");

            textView24.setText("0262222261");//number
            textView18.setText("Trincomalee-General");

            textView22.setText("0262234261");
            textView19.setText("Kantale-Base");

            textView26.setText("0672229261");//number
            textView16.setText("Kalmunai-Base");
        }


        else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

        }


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = textView25.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DepartmentContact_Hospital.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = textView26.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DepartmentContact_Hospital.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = textView24.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DepartmentContact_Hospital.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = textView23.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DepartmentContact_Hospital.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = textView22.getText().toString();

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Number not assigned", Toast.LENGTH_SHORT).show();

                } else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    if (ActivityCompat.checkSelfPermission(DepartmentContact_Hospital.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

        upernav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.nav_hospital)
                {
                    String text = textView21.getText().toString();
                    Intent intent = new Intent(getApplicationContext(),DepartmentContact_Hospital.class);
                    intent.putExtra(EXTRA_TEXT,text);
                    startActivity(intent);
                    finish();
                    return true;
                }

                if(menuItem.getItemId() == R.id.nav_police)
                {
                    String text = textView21.getText().toString();
                    Intent intent = new Intent(getApplicationContext(),departmentContacts.class);
                    intent.putExtra(EXTRA_TEXT,text);
                    startActivity(intent);
                    finish();
                    return true;
                }
                return false;
            }
        });

        }
    }
