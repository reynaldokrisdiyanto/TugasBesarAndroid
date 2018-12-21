package com.example.ihzar.tutorialloginsqlite;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Class tentang

public class tentang extends AppCompatActivity {

    //Deklarasi variabel
    Button gmaps, kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        //Intent : activity dapat berinteraksi dengan activity yang lain

        //Intent button kembali dari layout activity_tentang menuju layout activity_home
        kembali = (Button) findViewById(R.id.kembalitentang);    //untuk menghubungkan class tentang java dengan widget button
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), home.class);     //Intent ke home.class
                startActivity(i);
                finish();
            }
        });

        //Intent button gmaps dari layout activity_tentang menuju maps
        //CNN dapat memanggil komponen browser untuk URL tertentu menggunakan intent
        //Menuju maps
        gmaps = (Button) findViewById(R.id.maps);   //untuk menghubungkan class tentang java dengan widget button
        gmaps.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                //link yang dituju
                i.setData(Uri.parse("https://www.google.com/maps/place/Politeknik+Negeri+Malang/@-7.9465289,112.6155368,15z/data=!4m5!3m4!1s0x0:0x789ce9a636cd3aa2!8m2!3d-7.9465289!4d112.6155368"));
                startActivity(i);       //Memulai activity
            }
        }));
    }
}
