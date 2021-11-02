package com.kalbarprov.laporbencana.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kalbarprov.laporbencana.R;

import java.util.List;

public class KabupatenAdapter extends RecyclerView.Adapter<KabupatenAdapter.ViewHolder> {

    private List<GetKabupaten> getKabupatenList;

    public KabupatenAdapter(List<GetKabupaten> getKabupatenList) {
        this.getKabupatenList = getKabupatenList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_items_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvKabupaten.setText(getKabupatenList.get(position).getKabupaten());
        holder.tvLongitude.setText(getKabupatenList.get(position).getKoordinat_bujur());
        holder.tvLatitude.setText(getKabupatenList.get(position).getKoordinat_lintang());
        holder.tvAltitude.setText(getKabupatenList.get(position).getKetinggian());
    }

    @Override
    public int getItemCount() {
        return getKabupatenList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvKabupaten;
        TextView tvLongitude;
        TextView tvLatitude;
        TextView tvAltitude;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvKabupaten = itemView.findViewById(R.id.tv_kabupateni);
            tvLongitude = itemView.findViewById(R.id.tv_longitudei);
            tvLatitude = itemView.findViewById(R.id.tv_latitudei);
            tvAltitude = itemView.findViewById(R.id.tv_altitudei);
        }
    }
}
