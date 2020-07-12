package com.example.a3amil.Data;

import android.content.Context;

import com.example.a3amil.Model.EmployeeModel;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
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
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetroClient getINSTANCE(Context context) {
        if(INSTANCE == null)
            INSTANCE = new RetroClient(context);
        return INSTANCE;
    }
    public Observable<List<EmployeeModel>> getData(){
        return apiInterface.getEmployee();
    }
    public Observable<AuthenticationResponse> getToken(AuthenticationRequest request){
        return apiInterface.getToken(request);
    }

}

