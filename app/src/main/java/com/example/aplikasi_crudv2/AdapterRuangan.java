package com.example.aplikasi_crudv2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRuangan extends RecyclerView.Adapter<AdapterRuangan.HolderRuangan> {
    List<Ruangan> listRuangan;
    LayoutInflater inflater;
    Context context;

    public AdapterRuangan(Context context, List<Ruangan> listRuangan) {
        this.listRuangan = listRuangan;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public HolderRuangan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_ruangan, parent, false);
        return new HolderRuangan(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRuangan holder, int position) {
        Ruangan ruangan = listRuangan.get(position);
        holder.namaRuangan.setText(ruangan.getNama());
        holder.kodeRuangan.setText(ruangan.getKode());
        holder.getDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("id",ruangan.getKode());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listRuangan.size();
    }

    public class HolderRuangan extends RecyclerView.ViewHolder {
        TextView namaRuangan;
        TextView kodeRuangan;
        Button getDetail;
        public HolderRuangan(@NonNull View itemView) {
            super(itemView);

            namaRuangan = itemView.findViewById(R.id.nama_ruangan);
            kodeRuangan = itemView.findViewById(R.id.kode_ruangan);
            getDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
