package com.example.a3amil.Data;

import com.example.a3amil.Model.EmployeeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("Amil")
    Call<List<EmployeeModel>> getEmployee();
    @POST("/api/auth/token/")
    Call<AuthenticationResponse> getToken(@Body AuthenticationRequest authenticationRequest);


}
