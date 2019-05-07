package com.annaalfianim.annaalfianim.kuis_atk;

import android.content.SharedPreferences;

import com.annaalfianim.annaalfianim.kuis_atk.services.AtkService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    public static final String API = "http://192.168.1.2/";
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS).writeTimeout(30,TimeUnit.SECONDS).build();

    private static Retrofit instance(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(API).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
            return retrofit;
        }
        return retrofit;
    }
    public static AtkService getAtkService () {
        return instance().create(AtkService.class);
    }
}
