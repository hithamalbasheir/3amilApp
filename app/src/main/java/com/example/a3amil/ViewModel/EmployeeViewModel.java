package com.example.a3amil.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3amil.Data.RetroClient;
import com.example.a3amil.Model.RetroModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeViewModel extends ViewModel {
    public MutableLiveData<List<RetroModel>> liveData = new MutableLiveData<>();
    public void getModels(){
        RetroClient.getINSTANCE().getData().enqueue(new Callback<List<RetroModel>>() {
            @Override
            public void onResponse(Call<List<RetroModel>> call, Response<List<RetroModel>> response) {
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroModel>> call, Throwable t) {

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
