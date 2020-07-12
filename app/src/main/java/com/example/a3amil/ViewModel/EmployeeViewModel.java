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

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeViewModel extends AndroidViewModel {
    private static final String TAG = "EmployeeViewModel";
    public MutableLiveData<List<EmployeeModel>> liveData = new MutableLiveData<>();
    private AuthenticationResponse token = new AuthenticationResponse();
    private Context context = getApplication().getApplicationContext();
    private SessionManager sessionManager = new SessionManager(context);
    public EmployeeViewModel(@NonNull Application application) {
        super(application);
    }
    public void getToken(){
        Observable<AuthenticationResponse> tokenObservable = RetroClient.getINSTANCE(context)
                .getToken(new AuthenticationRequest("hithambasheir","Amil(1.0)"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        tokenObservable.subscribe(o -> {token = o;sessionManager.saveAuthToken(token.getAccess()); },
                e -> Log.d("Token Error", "getToken: "+e));
    }
    public void getModels(){
        Observable<List<EmployeeModel>> dataObservable = RetroClient.getINSTANCE(context).getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        dataObservable.subscribe(data -> liveData.setValue(data),e -> Log.d(TAG, "getModels: "+e));
//        .enqueue(new Callback<List<EmployeeModel>>() {
//            @Override
//            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
//                liveData.setValue(response.body());
//                Log.d("shit", "onResponse: blah body"+ response.body().get(1).getEmpNum());
//            }
//
//            @Override
//            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {
//
//            }
//        });
    }
//    MutableLiveData<String> EmpNameMutLive = new MutableLiveData<>();
//    MutableLiveData<String> EmpAddressMutLive = new MutableLiveData<>();
//    MutableLiveData<String> EmpNumMutLive = new MutableLiveData<>();
//    MutableLiveData<String> EmpJobMutLive = new MutableLiveData<>();

//    private EmployeeModel getEmployeeData(){
//        return new EmployeeModel();
//    }
}
