package com.example.a3amil.Data;
import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BasicAuthInterceptor implements Interceptor {

    private Context context;

    public BasicAuthInterceptor(Context context) {
        this.context = context;
    }

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        SessionManager manager = new SessionManager(context);
        String token = manager.fetchAuthToken();
        Request authenticatedRequest = request
                .newBuilder()
                .header("Authorization", "Bearer "+token)
                .build();
        return chain.proceed(authenticatedRequest);
    }

}