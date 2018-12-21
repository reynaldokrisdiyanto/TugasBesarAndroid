package com.example.ihzar.tutorialloginsqlite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

//Class berita

public class berita extends AppCompatActivity {

    //Deklarasi variabel
    private Button kembali;
    String Imageuri = "error.png";  //Mengisi dengan gambar error.png
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        //Intent button kembali dari layout activity_berita menuju layout activity_home
        kembali = findViewById(R.id.kembali);   //untuk menghubungkan class berita java dengan widget button
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), home.class);     //Intent ke home.class
                startActivity(i);
                finish();
            }
        });

        img = (ImageView) findViewById(R.id.imageView7);    //untuk menghubungkan class home java dengan widget ImageView

        //picasso digunakan diclass ini, meload gambar dan ditampilkan di variabel gambar yang terhubung dengan imageview
        Picasso.with(this).load(Imageuri).into(img);    //picasso untuk menampilkan gambar default
    }
}
