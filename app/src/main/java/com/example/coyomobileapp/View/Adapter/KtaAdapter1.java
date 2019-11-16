package com.example.coyomobileapp.View.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;

import java.util.List;

public class KtaAdapter1 extends RecyclerView.Adapter<KtaAdapter1.ViewHolder> {
    private List<Kta> dataKta;

    public KtaAdapter1(List<Kta> dataKtaa){
        this.dataKta = dataKtaa;
    }

    private Kta get(int position){
        return dataKta.get(position);
    }

    @NonNull
    @Override
    public KtaAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kta, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KtaAdapter1.ViewHolder holder, int position) {
        Kta dataUser = get(position);
        holder.bind(dataUser);

        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (dataKta == null) return 0;
        return dataKta.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDesc;
        ImageView imgPhoto;
        Button btnDetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.kta_title);
            txtDesc = itemView.findViewById(R.id.kta_description);
            btnDetails = itemView.findViewById(R.id.btnDetail);
            imgPhoto = itemView.findViewById(R.id.img_poster);
        }

        public void bind(final Kta dataBarang) {
            txtTitle.setText(dataBarang.getNama());
            txtDesc.setText(dataBarang.getHarga());
            //tvStok.setText(dataBarang.getStok());
        }
    }
}
