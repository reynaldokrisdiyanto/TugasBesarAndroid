package com.example.ihzar.tutorialloginsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

//Class home

public class home extends AppCompatActivity {

    //Deklarasi variabel
    private Button Logout1;
    Button tentang, galeri;
    String Imageuri = "@drawable/error.png";
    ImageView img;
    private TextView textclick1, textclick2, textclick3, textclick4, textclick5;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Instansiasi objek
        sessionManagement = new SessionManagement(this);

        //untuk menghubungkan class home java dengan widget ImageView
        img = (ImageView) findViewById(R.id.imageView);
        img = (ImageView) findViewById(R.id.imageView1);
        img = (ImageView) findViewById(R.id.imageView2);
        img = (ImageView) findViewById(R.id.imageView3);
        img = (ImageView) findViewById(R.id.imageView4);

        //picasso digunakan diclass ini, meload gambar dan ditampilkan di variabel gambar yang terhubung dengan imageview
        Picasso.with(this).load(Imageuri).into(img);        //picasso untuk menampilkan gambar default

        //Intent button tentang dari layout activity_home menuju layout activity_tentang
        tentang = findViewById(R.id.buttentang);    //untuk menghubungkan class home java dengan widget button
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), tentang.class);  //Intent ke tentang.class
                startActivity(i);
                finish();
            }
        });

        //Intent textclick1 dari layout activity_home menuju layout activity_berita
        textclick1 = findViewById(R.id.textView1);  //untuk menghubungkan class home java dengan widget button
        textclick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);   //Intent ke berita.class
                startActivity(i);
                finish();
            }
        });

        //Intent textclick2 dari layout activity_home menuju layout activity_berita
        textclick2 = findViewById(R.id.textView2);  //untuk menghubungkan class home java dengan widget button
        textclick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);   //Intent ke berita.class
                startActivity(i);
                finish();
            }
        });

        //Intent textclick3 dari layout activity_home menuju layout activity_berita
        textclick3 = findViewById(R.id.textView3);
        textclick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);   //Intent ke berita.class
                startActivity(i);
                finish();
            }
        });

        //Intent textclick4 dari layout activity_home menuju layout activity_berita
        textclick4 = findViewById(R.id.textView4);
        textclick4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);   //Intent ke berita.class
                startActivity(i);
                finish();
            }
        });

        //Intent textclick5 dari layout activity_home menuju layout activity_berita
        textclick5 = findViewById(R.id.textView5);
        textclick5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);   //Intent ke berita.class
                startActivity(i);
                finish();
            }
        });

        //Intent button logout1 dari layout activity_home menuju layout activity_login
        Logout1 = findViewById(R.id.buttlogout);
        Logout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);    //Intent ke login.class
                sessionManagement.logoutUser();     //Memanggil method logoutUser dari class SessionManagement
                startActivity(i);
                finish();
            }
        });
    }}
