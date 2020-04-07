package com.example.helloworld;

import com.example.helloworld.Entities.CoinLoreResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinService {
    @GET("api/tickers/")
    Call<CoinLoreResponse> getCoins();
}
