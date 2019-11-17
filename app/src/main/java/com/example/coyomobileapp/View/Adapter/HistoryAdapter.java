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
import com.example.coyomobileapp.Model.Ajuan;
import com.example.coyomobileapp.Model.Kta;
import com.example.coyomobileapp.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<Ajuan> ajuanList;
    private HistoryListener historyListener;

    public HistoryAdapter(List<Ajuan> ajuanList) {
        this.ajuanList = ajuanList;
    }

    private Ajuan get(int position){
        return ajuanList.get(position);
    }

    public void setAdapterListener(HistoryListener hl){
        this. historyListener= hl;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_history, parent, false);
        return new HistoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ajuan ajuan = get(position);
        holder.bind(ajuan, historyListener);
    }


    @Override
    public int getItemCount() {
        if (ajuanList == null) return 0;
        return ajuanList.size();
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
            tvNama = itemView.findViewById(R.id.tvHistory);
            tvDesc = itemView.findViewById(R.id.kta_description);
            btnDetails = itemView.findViewById(R.id.btnDetail);
            imageView = itemView.findViewById(R.id.img_poster);

        }

        void bind(final Ajuan dataBarang, final HistoryListener barangListener) {
            tvNama.setText(dataBarang.getAjuanKta());
//            tvDesc.setText(dataBarang.getShort_desc());
//            Glide.with(itemView.getContext())
//                    .load(dataBarang.getIcon())
//                    .apply(new RequestOptions().override(55, 55))
//                    .into(imageView);

//            btnDetails.setOnClickListener(v -> barangListener.onBarangClick(dataBarang));
        }
    }
}
