package com.annaalfianim.annaalfianim.kuis_atk.services;

import com.annaalfianim.annaalfianim.kuis_atk.models.AtkModel;
import com.annaalfianim.annaalfianim.kuis_atk.networks.BaseListResponse;
import com.annaalfianim.annaalfianim.kuis_atk.networks.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AtkService {
    @FormUrlEncoded
    @POST("api/film/tambah")
    Call<BaseResponse<AtkModel>> insert(@Field("title")String title, @Field("code")String code, @Field("category")String category);

    @GET("api/film")
    Call<BaseListResponse<AtkModel>> all();

}
