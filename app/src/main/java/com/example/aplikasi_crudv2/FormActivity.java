package com.example.aplikasi_crudv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    DataHelper dbcenter;
    EditText NamaRuang;
    EditText Kapasitas;
    EditText KodeRuang;
    EditText Gedung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbcenter = new DataHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Button btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
        NamaRuang = findViewById(R.id.edt_nama_ruang);
        Kapasitas = findViewById(R.id.edt_kapasitas_ruang);
        KodeRuang = findViewById(R.id.edt_kode_ruang);
        Gedung = findViewById(R.id.edt_gedung_ruang);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                Intent intentList = new Intent(FormActivity.this, MainActivity.class);
                startActivity(intentList);
                break;
            case R.id.action_form:
                Intent intentForm = new Intent(FormActivity.this, FormActivity.class);
                startActivity(intentForm);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_submit:
                // kode untuk insert ke database
                SQLiteDatabase db = dbcenter.getWritableDatabase();

                db.execSQL("insert into ruangan values ('" + KodeRuang.getText().toString() + "', '" + NamaRuang.getText().toString() + "', '"+ Integer.parseInt(Kapasitas.getText().toString()) +"', '"+ Gedung.getText().toString() +"'  );" );
                Toast.makeText(FormActivity.this, "DATA TERSIMPAN", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}