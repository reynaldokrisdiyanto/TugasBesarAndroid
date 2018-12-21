package com.example.ihzar.tutorialloginsqlite;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

//Class Galeri

public class Galeri extends AppCompatActivity {

    //Deklarasi variabel
    ImageView gambar;
    Button button_kamera, kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri);

        //Intent : activity dapat berinteraksi dengan activity yang lain

        gambar = (ImageView) findViewById(R.id.iv_gambar);  //untuk menghubungkan class galeri java dengan widget imageView

        //Intent button button_kamera dari layout activity_galeri menuju pengambilan gambar(kamera)
        button_kamera = (Button) findViewById(R.id.button); //untuk menghubungkan class galeri java dengan widget button
        button_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 1);
            }
        });

        //Intent button kembali dari layout activity_galeri menuju layout activity_home
        kembali = (Button) findViewById(R.id.kembali);  //untuk menghubungkan class galeri java dengan widget button
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), home.class); //Intent ke home.class
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(1 == requestCode && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            gambar.setImageBitmap(bitmap);
        }
    }
}

