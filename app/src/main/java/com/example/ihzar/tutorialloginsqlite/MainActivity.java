package com.example.ihzar.tutorialloginsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //instansiasi
    private Button Logout1;
    Button tentang, galeri;
    SessionManagement sessionManagement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instansiasi juga
        sessionManagement = new SessionManagement (this);
    // function logout yang digunakan untuk menghilangkan session
        tentang = findViewById(R.id.buttentang);
        Logout1 = (Button) findViewById(R.id.butlogout);
        Logout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                sessionManagement.logoutUser();
                startActivity(i);
                finish();
            }
        });
    }
}
