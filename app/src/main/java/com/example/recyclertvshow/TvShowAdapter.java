package com.example.recyclertvshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<TvShow> data;

    public TvShowAdapter(Context context, ArrayList<TvShow> data){
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listfilm, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TvShow film=data.get(position);
        holder.nama.setText(film.getNama());
        holder.desc.setText(film.getDesc());
        holder.photo.setImageResource(film.getFoto());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nama,desc;
        private ImageView photo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama=itemView.findViewById(R.id.text_Nama);
            desc=itemView.findViewById(R.id.text_desc);
            photo=itemView.findViewById(R.id.img_photo);
        }
    }
}
