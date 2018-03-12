package com.example.pc.taskapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by PC on 2018-03-12.
 */

public interface Api {

    String BASE_URL ="https://api.fixer.io/";
    @GET("latest")
    Call<Example> getExample();
}
