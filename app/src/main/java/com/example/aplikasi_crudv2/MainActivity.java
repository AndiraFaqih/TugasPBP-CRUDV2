package com.example.aplikasi_crudv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterRuangan adapterRuangan;
    List<Ruangan> listRuangan;
    Ruangan room1 = new Ruangan("Laboratorium", "A101");
    Ruangan room2 = new Ruangan("Ruang Dosen", "D102");
    Ruangan room3 = new Ruangan("Ruang Kelas", "D104");
    Ruangan room4 = new Ruangan("Ruang Rapat", "B101");
    Ruangan room5 = new Ruangan("Ruang Kelas", "D106");
    Ruangan room6 = new Ruangan("Ruang Kelas", "D108");

    DataHelper dbcenter;
    protected Cursor cursor;
    public MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        listRuangan = new ArrayList<>();

        // masukkin data dummy
        listRuangan.add(room1);
        listRuangan.add(room2);
        listRuangan.add(room3);
        listRuangan.add(room4);
        listRuangan.add(room5);
        listRuangan.add(room6);


        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterRuangan = new AdapterRuangan(this, listRuangan);
        recyclerView.setAdapter(adapterRuangan);
        adapterRuangan.notifyDataSetChanged();
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
                Intent intentList = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentList);
                break;
            case R.id.action_form:
                Intent intentForm = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intentForm);
                break;
        }
    }
}