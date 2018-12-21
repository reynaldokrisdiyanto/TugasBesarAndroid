package com.example.ihzar.tutorialloginsqlite;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Class Register

public class Register extends AppCompatActivity {

    //Deklarasi variabel
    Button  btnSignUp;
    DataHelper dbHelper;
    EditText edt_Username, edt_Email, edt_Password, edt_pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //instansiasi objek
        dbHelper = new DataHelper(this);

        //untuk menghubungkan class home java dengan widget Button
        btnSignUp = (Button) findViewById(R.id.buttonRegis);
        //untuk menghubungkan class home java dengan widget EditText
        edt_Username = (EditText) findViewById(R.id.edit_username);
        edt_Email = (EditText) findViewById(R.id.edit_Email);
        edt_Password = (EditText) findViewById(R.id.edit_Password);
        edt_pass2 = (EditText) findViewById(R.id.edit_confpassword);

        //ini adalah function yg dibuat untuk button btnSignUp
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            //ini adalah validasi untuk memastikan data telah terisi
            public void onClick(View view) {

                if(edt_Username.getText().toString().length()==0) {
                    edt_Username.setError("Username Tidak Boleh Kosong!");              //Validasi pesan error jika Username tidak diisi
                }
                else if(edt_Email.getText().toString().length()==0) {
                    edt_Email.setError("Email Tidak Boleh Kosong!");                    //Validasi pesan error jika Email tidak diisi
                }
                else if(edt_Password.getText().toString().length()==0) {
                    edt_Password.setError("Password Tidak Boleh Kosong!");              //Validasi pesan error jika Password tidak diisi
                }
                else if(edt_pass2.getText().toString().length()==0) {
                    edt_pass2.setError("Confirm Password Tidak Boleh Kosong!");         //Validasi pesan error jika Confirm Password tidak diisi
                }
                else {
                    //Jika Password dan ConfirmPassword sesuai
                    if (isMatch(edt_Password.getText().toString().trim(), edt_pass2.getText().toString().trim())) {
                        //Jika email valid
                        if (isValidEmail(edt_Email.getText().toString().trim())) {
                            SQLiteDatabase db = dbHelper.getWritableDatabase();
                            //insert ke tabel user
                            db.execSQL("insert into user(username, email, password) values('" + edt_Username.getText().toString() + "','" + edt_Email.getText().toString() + "','" + edt_Password.getText().toString() + "')");
                            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();      //Tampilkan informasi berhasil
                            Intent i = new Intent(getApplicationContext(), Login.class);    //intent ke Login.class
                            startActivity(i);
                            finish();
                        }
                        //Jika email tidak valid
                        else {
                            edt_Email.setError("Email Tidak Valid");
                        }
                    }
                    //Jika Password dan ConfirmPassword berbeda
                    else {
                        edt_pass2.setError("Pastikan Password Sama");
                        Toast.makeText(getApplicationContext(), "Pastikan Password Sama", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //ini adalah function yang digunakan untuk validasi email dan password, yang diatas merupakan fungsi panggilan dari
    //fungsi dibawah ini
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //Pengecekan Password
    private boolean isMatch(String password, String retypePassword){
        return password.equals(retypePassword);
    }

}
