package com.example.a3amil.Data;

import android.content.Context;

import com.example.a3amil.Model.EmployeeModel;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    private static String BASE_URL = "https://hithambasheir.pythonanywhere.com/";
    private ApiInterface apiInterface;
    Context context;
    private static RetroClient INSTANCE;
    public OkHttpClient initOkHttp(Context context){
        return new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(context))
                .build();
    }
    private RetroClient(Context context) {
        this.context = context;
        OkHttpClient client = initOkHttp(context);
        Retrofit retrofit = new Retrofit.Builder( )
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetroClient getINSTANCE(Context context) {
        if(INSTANCE == null)
            INSTANCE = new RetroClient(context);
        return INSTANCE;
    }
    public Call<List<EmployeeModel>> getData(){
        return apiInterface.getEmployee();
    }
    public Call<AuthenticationResponse> getToken(AuthenticationRequest request){
        return apiInterface.getToken(request);
    }

}

