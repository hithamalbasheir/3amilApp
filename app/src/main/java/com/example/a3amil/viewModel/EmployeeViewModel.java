package com.example.a3amil.viewModel;

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
import com.example.a3amil.model.EmployeeModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class EmployeeViewModel extends AndroidViewModel {
    private static final String TAG = "EmployeeViewModel";
    public MutableLiveData<List<EmployeeModel>> liveData = new MutableLiveData<>();
    private AuthenticationResponse token = new AuthenticationResponse();
    private Context context = getApplication().getApplicationContext();
    private SessionManager sessionManager = new SessionManager(context);
    public EmployeeViewModel(@NonNull Application application) {
        super(application);
    }
    private CompositeDisposable disposable = new CompositeDisposable();
    private void getToken(){
        Single<AuthenticationResponse> tokenObservable = RetroClient.getINSTANCE(context)
                .getToken(new AuthenticationRequest("",""))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        disposable.add(tokenObservable.subscribe(o -> {token = o;sessionManager.saveAuthToken(token.getAccess());
                    Log.d(TAG, "shit getToken: "+token); },
                e -> Log.d("Token shit Error", "getToken: "+e)));
    }
    public void getModels() {
        getToken();
        Single<List<EmployeeModel>> dataObservable = RetroClient.getINSTANCE(context).getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        disposable.add(dataObservable.subscribe(data -> liveData.setValue(data), e -> Log.d(TAG, "shit getModels: " + e)));
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
