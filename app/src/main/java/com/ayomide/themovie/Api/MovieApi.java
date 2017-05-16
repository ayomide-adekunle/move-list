package com.ayomide.themovie.Api;

import com.ayomide.themovie.Data.Model.Movie;
import com.ayomide.themovie.Data.Model.Review;
import com.ayomide.themovie.Data.Model.Video;

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
