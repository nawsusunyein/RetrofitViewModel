package com.example.retrofitviewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeroAdapter extends RecyclerView.Adapter<HeroViewHolder> {

    Context context;
    List<Hero> heroList;

    public HeroAdapter(Context context,List<Hero> heroList){
        this.context = context;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_layout,parent,false);

        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);
        Glide.with(context).load(hero.getImageurl()).into(holder.imgMovie);
        holder.txtMovieInfo.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }
}
