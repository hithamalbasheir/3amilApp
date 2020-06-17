package com.example.a3amil.Data;

import com.example.a3amil.Model.RetroModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("posts")
    public Call<List<RetroModel>> getEmployee();

}
