package ru.strongit.rssreader.model.rssModel;

/**
 * Created by user on 03.07.17.
 */

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Интерфейс Api для общения с интернет сервером
 */
public interface IRssApi {

    //Возвращает Rss ленту Аргументов и Фактов
    @GET("/rss/politics.php")
    Call<Rss> getPolitics();

//    @GET("/maps/api/place/autocomplete/json")
//    Call<GeoCode> getCityResults(
//              @Query("types") String types
//            , @Query("input") String input
//            , @Query("location") String location
//            , @Query("radius") Integer radius
//            , @Query("key") String key);
}