package com.example.movieapp.service;

import com.example.movieapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {

    // Base Url -->  https://api.themoviedb.org/3/
    // End Point Url -->  movie/popular?api_key=4d20b1a78a71271894045d1d82a4585b

    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);

}
