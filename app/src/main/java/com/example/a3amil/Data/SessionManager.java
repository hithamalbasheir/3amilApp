package com.example.a3amil.Data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.a3amil.R;

public final class SessionManager {
    private Context context;
    private static String USER_TOKEN = "user_token";
    private SharedPreferences prefs;

    public SessionManager(Context context) {
        this.context = context;
        initSharedPref(context);
    }

    private void initSharedPref(Context context) {
        prefs = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    /**
     * Function to save auth token
     */
    public void saveAuthToken(String token) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_TOKEN, token);
        editor.apply();
    }

    /**
     * Function to fetch auth token
     */
    String fetchAuthToken() {
        return prefs.getString(USER_TOKEN, null);
    }
}
