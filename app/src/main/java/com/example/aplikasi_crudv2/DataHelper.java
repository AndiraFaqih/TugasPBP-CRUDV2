package com.example.aplikasi_crudv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ruanganundip.db";
    private static final int DATABASE_VERSION = 1;

//    konstruktor
    public DataHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table ruangan(" +
                "kode_ruangan text primary key, " +
                "nama_ruangan text null, " +
                "kapasitas integer null, " +
                "gedung text null);";
        Log.d("Data", "onCreate"+sql);
        db.execSQL(sql);
    }

    // untuk menghadel kalau misal terdapat perubahan dalam database
    @Override
    public void onUpgrade(SQLiteDatabase arq0, int arg1, int arg2){

    }

}
