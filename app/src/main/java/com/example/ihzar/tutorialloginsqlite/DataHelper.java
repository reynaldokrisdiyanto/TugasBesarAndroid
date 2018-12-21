package com.example.ihzar.tutorialloginsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//Class DataHelper

public class DataHelper extends SQLiteOpenHelper {

    //Koneksi ke database
    //deklarasi nama database
    private static final String DATABASE_NAME = "tutorial.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    //fungsi yang digunakan untuk mengcreate dan menginsert data ke database
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //mengcreate / membuat table di database
        String sql = "create table user(id integer primary key, " +
                "username text null, " +
                "email text null, " +
                "password text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);

        //menginsert data ke database
        sql = "INSERT INTO user (id, username, email, password) VALUES ('1', 'ihzar11', 'ihzar11@gmail.com', 'kucing');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    @Override
//    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2, int arg3) {
//        // TODO Auto-generated method stub
//    }

}
