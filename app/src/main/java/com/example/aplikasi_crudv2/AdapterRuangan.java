package com.example.aplikasi_crudv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRuangan extends RecyclerView.Adapter<AdapterRuangan.HolderRuangan> {
    List<Ruangan> listRuangan;
    LayoutInflater inflater;

    public AdapterRuangan(Context context, List<Ruangan> listRuangan) {
        this.listRuangan = listRuangan;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderRuangan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_ruangan, parent, false);
        return new HolderRuangan(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRuangan holder, int position) {
        holder.namaRuangan.setText(listRuangan.get(position).getNama());
        holder.kodeRuangan.setText(listRuangan.get(position).getKode());
    }

    @Override
    public int getItemCount() {
        return listRuangan.size();
    }

    public class HolderRuangan extends RecyclerView.ViewHolder {
        TextView namaRuangan;
        TextView kodeRuangan;

        public HolderRuangan(@NonNull View itemView) {
            super(itemView);

            namaRuangan = itemView.findViewById(R.id.nama_ruangan);
            kodeRuangan = itemView.findViewById(R.id.kode_ruangan);
        }
    }
}
