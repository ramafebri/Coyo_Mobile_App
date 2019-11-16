package com.example.coyomobileapp.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        TextView tvNama, tvDesc;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            linearLayout = itemView.findViewById(R.id.linear_item2);
            tvNama = itemView.findViewById(R.id.kta_title1);
            tvDesc = itemView.findViewById(R.id.kta_description1);
            imageView = itemView.findViewById(R.id.img_poster);
        }

        public void bind(final Kta dataBarang, final KtaListener barangListener) {
            tvNama.setText(dataBarang.getTitle());
            tvDesc.setText(dataBarang.getShort_desc());
            Glide.with(itemView.getContext())
                    .load(dataBarang.getIcon())
                    .apply(new RequestOptions().override(85, 115))
                    .fitCenter()
                    .dontAnimate()
                    .into(imageView);

            linearLayout.setOnClickListener(v -> barangListener.onBarangClick(dataBarang));
        }
    }

}
