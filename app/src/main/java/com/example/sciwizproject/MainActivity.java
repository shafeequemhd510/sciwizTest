package com.example.sciwizproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.acl.Owner;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
//        Button btn_netWorkRequest=findViewById(R.id.button);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubClient service = retrofit.create(GitHubClient.class);


        Call<Filims> callFilms = service.getfilims();
        callFilms.enqueue(new Callback<Filims>() {
            @Override
            public void onResponse(Call<Filims> call, Response<Filims> response) {

                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(new FilimsAdapter(response.body().getResults()));
            }

            @Override
            public void onFailure(Call<Filims> call, Throwable t) {
                Log.d("vw", "onFailure: "+t.getMessage());
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

            }


        });
    }
}
