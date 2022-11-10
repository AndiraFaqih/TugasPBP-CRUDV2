package com.example.aplikasi_crudv2;

public class Ruangan {
    private String nama;
    private String kode;
    private String gedung;
    private int kapasitas;

    public Ruangan(String kode, String nama, int kapasitas, String gedung ) {
        this.nama = nama;
        this.kode = kode;
        this.kapasitas = kapasitas;
        this.gedung = gedung;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
