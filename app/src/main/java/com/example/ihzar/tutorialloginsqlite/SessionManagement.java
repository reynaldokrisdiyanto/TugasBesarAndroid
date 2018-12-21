package com.example.ihzar.tutorialloginsqlite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManagement {

    //SharedPreference : Untuk menyimpan data dalam ukuran kecil
    private SharedPreferences mSharedPreference;
    //Editor untuk SharedPreference
    private SharedPreferences.Editor mEditor;
    // context
    private Context mContext;
    //mode SharedPreference
    int PRIVATE_MODE;
    //nama SharedPreference
    private static final String PREF_NAME = "SharedPrefLatihan";

    // Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "username";

    public SessionManagement(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mSharedPreference.edit();
    }

    //Untuk menyimpan SharedPreference dengan nama createLoginSession
    public void createLoginSession(String username, String password) {
        //Membuat Session Login
        mEditor.putBoolean(IS_LOGIN, true);             //Menyimpan nilai login as true
        mEditor.putString(KEY_USERNAME, username);      //Menyimpan username
        mEditor.putString(KEY_PASSWORD, password);      //Menyimpan password
        mEditor.commit();
    }

    //Untuk mendapatkan informasi member
    //Hashmap adalah class implementasi dari map, map itu sendiri adalah interface yang memiliki fungsi untuk memetakan nilai dengan key unik.
    public HashMap<String, String> getUserInformation()
    {
        //
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_USERNAME, mSharedPreference.getString(KEY_USERNAME, null));        //Username member
        user.put(KEY_PASSWORD, mSharedPreference.getString(KEY_PASSWORD, null));        //Password member
        return user;
    }

    //Untuk mengecek apakah user sudah login atau belum
    public boolean isLoggedIn() {
        return mSharedPreference.getBoolean(IS_LOGIN, false);
    }

    public void checkIsLogin() {
        if (!isLoggedIn()) {
            Intent i = new Intent(mContext, MainActivity.class);  //User tidak dapat mengalihkan login ke MainActivity
            //Menutup semua activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            //Menambah new flag untuk memulai new activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
            }
    }

    //Untuk menghapus Shared Preference yang telah disimpan
    public void logoutUser(){
        //Menghilangkan session
        //Menghapus semua data dari Shared Preference
        mEditor.clear();
        mEditor.commit();

        //Setelah logout mengalihkan user ke Login Activity
        Intent i = new Intent(mContext, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}