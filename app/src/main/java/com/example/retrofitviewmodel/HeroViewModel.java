package com.example.retrofitviewmodel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroViewModel extends AndroidViewModel {

    private MutableLiveData<List<Hero>> heroList;

    public HeroViewModel(Application context){
        super(context);
    }

    public LiveData<List<Hero>> getHeroes(){
        if(heroList == null){
            heroList = new MutableLiveData<List<Hero>>();
            loadHeroes();
        }
        return heroList;
    }


    private void loadHeroes(){
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(Api.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        Api api = retrofit.create(Api.class);
        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Log.d("Errror here" ,t.getMessage());
                Toast.makeText(getApplication(),"Error : " + t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
