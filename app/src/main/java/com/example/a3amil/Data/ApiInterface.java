package com.example.a3amil.Data;

import com.example.a3amil.Model.EmployeeModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("Amil")
    Observable<List<EmployeeModel>> getEmployee();
    @POST("/api/auth/token/")
    Observable<AuthenticationResponse> getToken(@Body AuthenticationRequest authenticationRequest);


}
