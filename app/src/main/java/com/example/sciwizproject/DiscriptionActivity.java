package com.example.sciwizproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiscriptionActivity extends AppCompatActivity {
    TextView tv;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discription);

       tv=findViewById(R.id.textView13);
       tv2=findViewById(R.id.textView14);
       tv3=findViewById(R.id.textView15);
       tv4=findViewById(R.id.textView16);
       tv5=findViewById(R.id.textView17);
       tv6=findViewById(R.id.textView20);

        String url;
        String title;
        String director;
        String producer;
        String releaseDates;
        String description;



        if (getIntent().hasExtra("url")) {
            url = getIntent().getStringExtra("url");
            title = getIntent().getStringExtra("title");
            director = getIntent().getStringExtra("director");
            producer = getIntent().getStringExtra("producer");
            releaseDates = getIntent().getStringExtra("ReleaseDates");
            description = getIntent().getStringExtra("Discription");

            tv.setText(title);
            tv2.setText("Director      :"+director);
            tv3.setText("Producer      :"+producer);
            tv4.setText("Discription");
            tv5.setText(description);
            tv6.setText("ReleaseDates  :"+releaseDates);

        }
    }
}
