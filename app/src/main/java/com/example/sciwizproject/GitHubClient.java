package com.example.sciwizproject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

interface GitHubClient {
/*    @GET("films")
    Call<Result> getfilims();*/
    @GET("films")
    Call<Filims> getfilims();


}
