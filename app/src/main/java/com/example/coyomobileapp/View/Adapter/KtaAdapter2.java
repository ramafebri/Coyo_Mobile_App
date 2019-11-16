package com.example.coyomobileapp.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;

import java.util.List;

public class KtaAdapter2 extends RecyclerView.Adapter<KtaAdapter2.ViewHolder> {
    private List<Kta> dataKta;
    private KtaListener ktaListener;

    public KtaAdapter2(List<Kta> dataKtaa){
        this.dataKta = dataKtaa;
    }

    private Kta get(int position){
        return dataKta.get(position);
    }

    public void setAdapterListener(KtaListener barangListener){
        this.ktaListener = barangListener;
    }

    @NonNull
    @Override
    public KtaAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_kta2, parent, false);
        return new KtaAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Kta dataUser = get(position);
        holder.bind(dataUser,ktaListener);
    }

    @Override
    public int getItemCount() {
        if (dataKta == null) return 0;
        return dataKta.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView tvNama, tvHarga, tvStok;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
//            linearLayout = itemView.findViewById(R.id.linear_item2);
//            tvNama = itemView.findViewById(R.id.kta_title1);
//            tvHarga = itemView.findViewById(R.id.kta_description1);
            //tvStok = itemView.findViewById(R.id.tvStok);
        }

        public void bind(final Kta dataBarang, final KtaListener barangListener) {
//            tvNama.setText(dataBarang.getNama());
//            tvHarga.setText(dataBarang.getHarga());
            //tvStok.setText(dataBarang.getStok());

            linearLayout.setOnClickListener(v -> barangListener.onBarangClick(dataBarang));
        }
    }

}
