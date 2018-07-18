package com.example.lap11799.viber.data;

import com.example.lap11799.viber.entity.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/posts?userId=1")
    Call<List<Post>> getAllData();
}