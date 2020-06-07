package com.example.recyclertvshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<TvShow> data;

    private View view;
    private GridLayoutManager gridLayoutManager;
    private TvShow film;

    public TvShowAdapter(Context context, ArrayList<TvShow> data){
        this.context=context;
        this.data=data;
    }

    public void init(GridLayoutManager gridLayoutManager) {
        this.gridLayoutManager=gridLayoutManager;
    }

    @Override
    public int getItemViewType(int position) {
        int spanCount=gridLayoutManager.getSpanCount();
        if (spanCount==1){
            return 1;
        }
        else {
            return 2;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.listfilm, parent, false);
        }
        else {
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.gridfilm, parent, false);
        }

        return new MyViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        film=data.get(position);
        if(holder.getItemViewType()==1){
            holder.nama.setText(film.getNama());
            holder.desc.setText(film.getDesc());
            holder.photo.setImageResource(film.getFoto());
        }
        else {
            holder.nama.setText(film.getNama());
            holder.photo.setImageResource(film.getFoto());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nama,desc;
        private ImageView photo;
        public MyViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            if (viewType==1){
                nama=itemView.findViewById(R.id.text_Nama);
                desc=itemView.findViewById(R.id.text_desc);
                photo=itemView.findViewById(R.id.img_photo);
            }else {
                nama=itemView.findViewById(R.id.grid_title);
                photo=itemView.findViewById(R.id.grid_img);
            }
        }
    }
}
