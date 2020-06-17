package com.example.a3amil.Data;

import com.example.a3amil.Model.RetroModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    private static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private ApiInterface apiInterface;
    private static RetroClient INSTANCE;
    public RetroClient() {
        Retrofit retrofit = new Retrofit.Builder( )
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetroClient getINSTANCE() {
        if(INSTANCE == null)
            INSTANCE = new RetroClient();
        return INSTANCE;
    }

    public Call<List<RetroModel>> getData(){
        return apiInterface.getEmployee();
    }
}

