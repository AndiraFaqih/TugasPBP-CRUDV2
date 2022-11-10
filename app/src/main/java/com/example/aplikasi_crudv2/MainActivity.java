package com.example.aplikasi_crudv2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DataHelper dbcenter;
    protected Cursor cursor;
    public MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}