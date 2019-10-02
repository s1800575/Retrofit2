package com.example.retrofit2;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import org.w3c.dom.Comment;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId,
            // Integer[] jotta voi antaa monta userID:tä
            // silloin määritä Main parameters New Integer[]{1,2)
            @Query("_sort") String sort,
            @Query("_order") String order
    );
    // näillä arvoilla voidaan sortata ja järjestää listaa, mikä näytetään käyttäjälle
    // --> URL manipulation --> esim. /posts?userid=1&_sort=title&_order=desc
    // millä haetaan user id 1 kirjoittamat postaukset ja ne järjestetään titlen mukaan
    // laskevaan järjestykseen

    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);
    //{id} arvo saadaan muuttujasta int postId, mikä määritellään sitten ohjelmassa ohjelmassa

    @GET
    Call<List<com.example.retrofit2.Comment>> getComments(@Url String url);
    //haetaan url perusteella kommentit
}