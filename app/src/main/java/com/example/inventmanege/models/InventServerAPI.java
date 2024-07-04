package com.example.inventmanege.models;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface InventServerAPI {
    @GET("auth/logIn")
    Call<Worker> getUser(@QueryMap Map<String, String> params);

    @GET("inventory/byResp")
    Call<List<Inventory>> getByResp(@QueryMap Map<String, String> params);

    @GET("inventory/costume")
    Call<List<Inventory>> getCostumes(@QueryMap Map<String, String> params);

    @GET("inventory/requisite")
    Call<List<Inventory>> getRequisites(@QueryMap Map<String, String> params);

    @GET("inventory/decoration")
    Call<List<Inventory>> getDecorations(@QueryMap Map<String, String> params);

    @GET("worker")
    Call<List<Worker>> getWorkers(@QueryMap Map<String, String> params);

    @GET("car")
    Call<List<Car>> getCars(@QueryMap Map<String, String> params);

    @GET("storage")
    Call<List<Storage>> getStorages(@QueryMap Map<String, String> params);
}
