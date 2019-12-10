package com.example.retrofitviewmodel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class HeroViewHolder extends RecyclerView.ViewHolder {

    ImageView imgMovie;
    TextView txtMovieInfo;

    public HeroViewHolder(View itemView){
        super(itemView);
        imgMovie = (ImageView) itemView.findViewById(R.id.imgMovie);
        txtMovieInfo = (TextView) itemView.findViewById(R.id.txtInfo);
    }
}
