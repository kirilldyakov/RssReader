package ru.strongit.rssreader.common;



import okhttp3.OkHttpClient;
//import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.strongit.rssreader.model.rssModel.IRssApi;


import static ru.strongit.rssreader.RssReaderApp.API_BASE_URL;


/**
 * Created by user on 22.06.17.
 */

public class RetrofitHelper {
    private static IRssApi rssRTFT;



    public static IRssApi getRssRTFT() {
        if (rssRTFT == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .client(new OkHttpClient())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();

            rssRTFT = retrofit.create(IRssApi.class);
        }
        return rssRTFT;
    }



}
