package com.example.a3amil.Data;

import com.example.a3amil.model.EmployeeModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("Amil")
    Single<List<EmployeeModel>> getEmployee();
    @POST("/api/auth/token/")
    Single<AuthenticationResponse> getToken(@Body AuthenticationRequest authenticationRequest);



}
