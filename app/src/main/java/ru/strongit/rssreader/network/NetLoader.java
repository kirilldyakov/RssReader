package ru.strongit.rssreader.network;

import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.strongit.rssreader.common.RetrofitHelper;
import ru.strongit.rssreader.model.rssModel.Rss;

import static ru.strongit.rssreader.RssReaderApp.getAppContext;

/**
 * Created by user on 01.10.17.
 */

public class NetLoader {

    private static OnDataLoadedListener onDataLoadedListener;

    public void setOnEventListener(OnDataLoadedListener listener) {

        onDataLoadedListener = listener;

    }


    public static void loadRssNewsFromWWW() {

        RetrofitHelper.getRssRTFT().getPolitics().enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {

                Rss rss = response.body();

                if (rss != null) {

                    Gson gson = new Gson();

                    String json = gson.toJson(rss.getChannel());

                    if (onDataLoadedListener != null)

                        onDataLoadedListener.onDataLoadetEvent(json);

                }


            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Toast.makeText(getAppContext(), "Ошибка при полученнии новостей", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
