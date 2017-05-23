package com.ayomide.themovie.api;

import com.ayomide.themovie.data.model.Movie;
import com.ayomide.themovie.data.model.Review;
import com.ayomide.themovie.data.model.Video;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface MovieApi {

    @GET("movie/{type}")
    Observable<Movie.SearchResult> getMovies(@Path("type") String type);

    @GET("movie/{id}/videos")
    Observable<Video.SearchResult> getVideos(@Path("id") long id);

    @GET("movie/{id}/reviews")
    Observable<Review.SearchResult> getReviews(@Path("id") long id);
}
