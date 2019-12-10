package com.example.retrofitviewmodel;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView heroRecyclerView;
    HeroAdapter adapter;
    HeroViewModel heroViewModel;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heroRecyclerView = (RecyclerView) findViewById(R.id.heroRecyclerView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        heroRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        progressBar.setVisibility(View.VISIBLE);

        heroViewModel = ViewModelProviders.of(this).get(HeroViewModel.class);
        heroViewModel.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                progressBar.setVisibility(View.GONE);
                adapter = new HeroAdapter(MainActivity.this,heroList);
                heroRecyclerView.setAdapter(adapter);
            }
        });
    }
}
