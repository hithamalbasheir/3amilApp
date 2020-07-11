package com.example.a3amil.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.a3amil.Data.AuthenticationRequest;
import com.example.a3amil.Data.AuthenticationResponse;
import com.example.a3amil.Data.RetroClient;
import com.example.a3amil.Data.SessionManager;
import com.example.a3amil.Model.EmployeeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeViewModel extends AndroidViewModel {
    public MutableLiveData<List<EmployeeModel>> liveData = new MutableLiveData<>();
    private AuthenticationResponse token = new AuthenticationResponse();
    private Context context = getApplication().getApplicationContext();
    private SessionManager sessionManager = new SessionManager(context);
    public EmployeeViewModel(@NonNull Application application) {
        super(application);
    }
    public void getToken(){
        RetroClient.getINSTANCE(context).getToken(new AuthenticationRequest("hithambasheir","Amil(1.0)"))
                .enqueue(new Callback<AuthenticationResponse>() {
                    @Override
                    public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {
                        token = response.body();
                        Log.d("token response", "onResponse: blah token is  "+ token.getAccess());
                        Log.d("token response", "onResponse: blah refresh token is  "+ token.getRefresh());
                        sessionManager.saveAuthToken(token.getAccess());
                    }
                    @Override
                    public void onFailure(Call<AuthenticationResponse> call, Throwable t) {
                        Log.d("token failed", "onFailure: blah failed "+t);
                    }
                });
    }
    public void getModels(){
        RetroClient.getINSTANCE(context).getData().enqueue(new Callback<List<EmployeeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
                liveData.setValue(response.body());
                Log.d("shit", "onResponse: blah body"+ response.body().get(1).getEmpNum());
            }

            @Override
            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {

            }
        });
    }
//    MutableLiveData<String> EmpNameMutLive = new MutableLiveData<>();
//    MutableLiveData<String> EmpAddressMutLive = new MutableLiveData<>();
//    MutableLiveData<String> EmpNumMutLive = new MutableLiveData<>();
//    MutableLiveData<String> EmpJobMutLive = new MutableLiveData<>();

//    private EmployeeModel getEmployeeData(){
//        return new EmployeeModel();
//    }
}
