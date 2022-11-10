package com.example.aplikasi_crudv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    DataHelper dbcenter;
    protected Cursor cursor;
    String KodeRuangan;
    String NamaRuangan;
    int Kapasitas;
    String Gedung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dbcenter = new DataHelper(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM ruangan WHERE kode_ruangan='"+id+"'", null);
        cursor.moveToFirst();
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            KodeRuangan = cursor.getString(0).toString();
            NamaRuangan = cursor.getString(1).toString();
            Kapasitas = Integer.parseInt(cursor.getString(2));
            Gedung = cursor.getString(3).toString();
        }

        TextView kod = findViewById(R.id.kod);
        TextView nam = findViewById(R.id.nama_r);
        TextView kap = findViewById(R.id.kap);
        TextView ged = findViewById(R.id.ged);

        kod.setText(KodeRuangan);
        nam.setText(NamaRuangan);
        kap.setText(Integer.toString(Kapasitas));
        ged.setText(Gedung);
    }
}