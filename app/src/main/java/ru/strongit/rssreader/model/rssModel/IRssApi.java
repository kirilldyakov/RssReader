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




//    //Возвращает название местности по коордиатам
//    @GET("/api/c7409bebc12a3b47/conditions/forecast10day/q/{latitude},{longitude}.json")
//    Call<Shops> getForcast(@Path("latitude") String latitude, @Path("longitude") String longitude);

    //Возвращает информацию о магазинах
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