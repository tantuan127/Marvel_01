package com.framgia.marvel01.service;

import com.framgia.marvel01.data.MarvelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by levutantuan on 3/10/17.
 */
public interface MarvelService {
    @GET("v1/public/characters")
    Call<MarvelResponse> getCharacters(
        @Query("ts") long timeStap,
        @Query("apikey") String apiKey,
        @Query("hash") String hash);
}