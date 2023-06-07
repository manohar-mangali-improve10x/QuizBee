package com.example.quizbee.network;

import com.example.quizbee.model.Quiz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OnServiceApi {
    @GET("renuTodo")
    Call<List<Quiz>> getDataApi();
}
