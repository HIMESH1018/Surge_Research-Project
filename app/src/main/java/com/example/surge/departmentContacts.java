package com.example.surge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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

public class departmentContacts extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    BottomNavigationView bottomnav,upernav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_contacts);

        Intent intent = getIntent();
        final String text = intent.getStringExtra(EXTRA_TEXT);

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

            textView25.setText("0112433342");//number
            textView15.setText("Colombo-Central");

            textView23.setText("0112911444");//number
            textView17.setText("Kelaniya");

            textView24.setText("0332222228");//number
            textView18.setText("Gampaha");

            textView22.setText("0312226181");
            textView19.setText("Negombo");

            textView26.setText("0382232227");//number
            textView16.setText("Panadura");

        }

        //North Western Province
        else if (text.equals(NW)) {
            textView25.setText("0372222228");//number
            textView15.setText("Kurunegala");

            textView23.setText("0372281227");//number
            textView17.setText("Kuliyapitiya");

            textView24.setText("037220343");//number
            textView18.setText("Nikaweratiya");

            textView22.setText("0322266446");
            textView19.setText("Puttalam");

            textView26.setText("0322223222");//number
            textView16.setText("Chilaw");
        }

        //Central Province
        else if (text.equals(CP)) {
            textView25.setText("0662222227");//number
            textView15.setText("Matale");

            textView23.setText("0522222228");//number
            textView17.setText("Nuwaraeliya");

            textView24.setText("0512222227");//number
            textView18.setText("Hatton");

            textView22.setText("0812233004");
            textView19.setText("Kandy");

            textView26.setText("0812352227");//number
            textView16.setText("Gampola");
        }

        //Northern Province
        else if (text.equals(NP)) {
            textView25.setText("0212059085");//number
            textView15.setText("Kankasanthurai");

            textView23.setText("0213217444");//number
            textView17.setText("Jaffna");

            textView24.setText("0242222228");//number
            textView18.setText("Vavuniya");

            textView22.setText("0212285503");
            textView19.setText("Kilinochchi");

            textView26.setText("0232222227");//number
            textView16.setText("Mannar");
        }

        //Uva Province
        else if (text.equals(uva)) {
            textView25.setText("0552222228");//number
            textView15.setText("Badulla");

            textView23.setText("0572223422");//number
            textView17.setText("Bandarawela");

            textView24.setText("0552276228");//number
            textView18.setText("Monaragala");

            textView22.setText("0472285022");
            textView19.setText("Thanamalwila");

            textView26.setText("0572228850");//number
            textView16.setText("Ella");
        }

        //Southern Province
        else if (text.equals(SP)) {
            textView25.setText("0412222228");//number
            textView15.setText("Mathara");

            textView23.setText("0912232061");//number
            textView17.setText("Galle");

            textView24.setText("0912291032");//number
            textView18.setText("Elpitiya");

            textView22.setText("0472240228");
            textView19.setText("Tangalle");

            textView26.setText("0472220223");//number
            textView16.setText("Hambanthota");
        }

        //Sabaragamua Province
        else if (text.equals(SG)) {
            textView25.setText("0452222228");//number
            textView15.setText("Rathnapura");

            textView23.setText("0352222228");//number
            textView17.setText("Kegalle");

            textView24.setText("0362222118");//number
            textView18.setText("Seethawakapura");

            textView22.setText("0472263226");
            textView19.setText("Embilipitiya");

            textView26.setText("0452287422");//number
            textView16.setText("Balangoda");
        }

        //North Central Province
        else if (text.equals(NC)) {
            textView25.setText("0252222228");//number
            textView15.setText("Anuradhapura");

            textView23.setText("0272222228");//number
            textView17.setText("Polonnaruwa");

            textView24.setText("0272257222");//number
            textView18.setText("Aranaganwila");

            textView22.setText("0252277426");
            textView19.setText("Horowpathana");

            textView26.setText("0252245888");//number
            textView16.setText("Medawachchiya");
        }

        //Eastern Province
        else if (text.equals(EP)) {
            textView25.setText("0652224412");//number
            textView15.setText("Batticaloa");

            textView23.setText("0632222227");//number
            textView17.setText("Ampara");

            textView24.setText("0262221230");//number
            textView18.setText("Trincomalee");

            textView22.setText("0262234244");
            textView19.setText("Kantale");

            textView26.setText("0672229226");//number
            textView16.setText("Kalmunai");
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
                    if (ActivityCompat.checkSelfPermission(departmentContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
                    if (ActivityCompat.checkSelfPermission(departmentContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
                    if (ActivityCompat.checkSelfPermission(departmentContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
                    if (ActivityCompat.checkSelfPermission(departmentContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
                    if (ActivityCompat.checkSelfPermission(departmentContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
                Intent intent = new Intent(getApplicationContext(),donation.class);
                overridePendingTransition(0,0);
                startActivity(intent);
                finish();
                return true;
            }
            if(menuItem.getItemId() == R.id.nav_safeplaces)
            {
                Intent intent = new Intent(getApplicationContext(),SafeplacesMain.class);
                overridePendingTransition(0,0);
                startActivity(intent);
                finish();
                return true;
            }
            if(menuItem.getItemId() == R.id.nav_uploader)
            {
                Intent intent = new Intent(getApplicationContext(),uploader.class);
                overridePendingTransition(0,0);
                startActivity(intent);
                finish();
                return true;
            }
            if(menuItem.getItemId() == R.id.nav_waterlevel)
            {
                Intent intent = new Intent(getApplicationContext(),Waterlevel.class);
                overridePendingTransition(0,0);
                startActivity(intent);
                finish();
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
