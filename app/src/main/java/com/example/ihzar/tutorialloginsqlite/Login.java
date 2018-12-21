package com.example.ihzar.tutorialloginsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Class Login

public class Login extends AppCompatActivity {

    //instansiasi / deklarasi variabel
    DataHelper dbHelper;
    EditText edtUser, edtPassword;
    Button buttonLogin;
    Button buttonregis;
    //String email,password;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //instansiasi objek layout ke class javanya
        sessionManagement = new SessionManagement(this);
        dbHelper = new DataHelper(this);

        //untuk menghubungkan class login java dengan widget EditText
        edtUser = findViewById(R.id.editUsername);
        edtPassword = findViewById(R.id.editPassword);

        //untuk menghubungkan class login java dengan widget Button
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonregis = findViewById(R.id.buttonReg);

        //pengecekan session user, apakah sudah login atau belum
        //Ketika button di klik, sudah login (true), belum login (false)
        if (sessionManagement.isLoggedIn()) {
            goToActivity();
            finish();
        }

        //ini fungsi button login, memanggil function validasi
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CekLogin()){
                    if (cekValidasi()) {
                        Toast.makeText(getApplicationContext(),"Benar",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), home.class);

                        //Memanggil method createLoginSession yang ada di class SessionManagement
                        sessionManagement.createLoginSession(edtUser.getText().toString(),edtPassword.getText().toString());

                        startActivity(i);
                        finish();
                    }
                }
                //Jika belum terdaftar
                else{
                    Toast.makeText(getApplicationContext(),"Anda belum terdaftar",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //ini fungsi intent ke form register
        //Intent button buttonregis dari layout activity_login menuju layout activity_register
        buttonregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Register.class);      //intent ke Register.class
                startActivity(i);
                finish();
            }
        });
    }

    //fungsi validasi ceklogin yang mana User / Member yang sudah melakukan daftar
    public boolean CekLogin(){

        //Instansiasi objek
        SessionManagement sessionManagement = new SessionManagement(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user WHERE username ='"+edtUser.getText().toString()+"' and password='"+edtPassword.getText().toString()+"'", null);

        //sessionManagement.tampilkan(username.getText().toString(), cursor.getString(1).toString(), cursor.getString(2).toString(), password.getText().toString());

        if(cursor.getCount()>0) return true;
        else return false;
    }

    //untuk pengecekan apakah username dan password telah terisi dengan benar
    private boolean cekValidasi()
    {
        //Jika Username tidak diisi
        if (edtUser.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Username harus diisi", Toast.LENGTH_SHORT).show();
            return false;
        }
        //Jika Password tidak diisi
        else if (edtPassword.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Password harus diisi", Toast.LENGTH_SHORT).show();
            return false;
        }
        //Jika Username dan Password telah terisi
        else
        {
            return true;
        }
    }

    //ini adalah function / method untuk menuju layout activity_home
    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(), home.class);       //Intent ke home.class
        startActivity(mIntent);
        finish();
    }

}