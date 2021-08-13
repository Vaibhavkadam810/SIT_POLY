package com.empire.sitpoly.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "http://192.168.1.101/retrofit/";

    @GET("index.php")
    Call<List<Example>> getData();

    @POST("index.php")
    Call<Example> sendData(@Body Example example);

}
