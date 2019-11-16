package com.example.coyomobileapp.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;

import java.util.List;

public class KtaAdapter1 extends RecyclerView.Adapter<KtaAdapter1.ViewHolder> {
    private List<Kta> dataKta;
    private KtaListener ktaListener;

    public KtaAdapter1(List<Kta> dataKtaa){
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
    public KtaAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_kta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KtaAdapter1.ViewHolder holder, int position) {
        Kta dataUser = get(position);
        holder.bind(dataUser,ktaListener);
    }

    @Override
    public int getItemCount() {
        if (dataKta == null) return 0;
        return dataKta.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView tvNama, tvDesc;
        ImageView imageView;
        Button btnDetails;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            linearLayout = itemView.findViewById(R.id.linear_item);
            tvNama = itemView.findViewById(R.id.kta_title);
            tvDesc = itemView.findViewById(R.id.kta_description);
            btnDetails = itemView.findViewById(R.id.btnDetail);
            imageView = itemView.findViewById(R.id.img_poster);

        }

        void bind(final Kta dataBarang, final KtaListener barangListener) {
            tvNama.setText(dataBarang.getTitle());
            tvDesc.setText(dataBarang.getShort_desc());
            Glide.with(itemView.getContext())
                    .load(dataBarang.getIcon())
                    .apply(new RequestOptions().override(55, 55))
                    .into(imageView);

            btnDetails.setOnClickListener(v -> barangListener.onBarangClick(dataBarang));
        }
    }

    }

