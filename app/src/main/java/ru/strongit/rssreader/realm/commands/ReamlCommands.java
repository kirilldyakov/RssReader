package ru.strongit.rssreader.realm.commands;

import android.util.Log;

import com.google.gson.Gson;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.strongit.rssreader.common.RetrofitHelper;
import ru.strongit.rssreader.model.rssModel.Rss;
import ru.strongit.rssreader.realm.model.Item;

import static ru.strongit.rssreader.common.SoundUtils.beep;

/**
 * Created by user on 05.09.17.
 */

public class ReamlCommands {

    private static String TAG ="TAG";

    public static void getNewRssNews() {
        RetrofitHelper.getRssRTFT().getPolitics().enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                Rss rss = response.body();


                Gson gson = new Gson();
                String json = gson.toJson(rss);


//                try {
//                    Realm realm = Realm.getDefaultInstance();
//                    realm.beginTransaction();
//
//                    //realm.createAllFromJson(Channel.class, json); // Save a bunch of new Customer objects
//                    realm.createOrUpdateAllFromJson(Channel.class, json); // Save a bunch of new Customer objects
//
//                    realm.commitTransaction();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.e(TAG, "onResponse: " + e.getMessage());
//                }

//
//                realm.beginTransaction();
//                ru.strongit.rssreader.realm.model.Rss rRss = new ru.strongit.rssreader.realm.model.Rss();
//                rRss.setVersion(Double.valueOf(rss.getVersion().toString()));
//                rRss.
                storeRssToRealm(rss);


                Log.d(TAG, "onResponse: ");
                beep();
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
                beep();
            }
        });
    }

    private static void storeRssToRealm(Rss rss) {
        Realm realm = Realm.getDefaultInstance();


        for (int i = 0; i < rss.getChannel().getItem().size(); i++) {

            realm.beginTransaction();

            Item itm = new Item();

            itm.setmGuid(rss.getChannel().getItem().get(i).getGuid().getTextValue());

            itm.setmDescription(rss.getChannel().getItem().get(i).getDescription().getCdataSection());

            itm.setmLink(rss.getChannel().getItem().get(i).getLink());

            itm.setmPubDate(rss.getChannel().getItem().get(i).getPubDate());

            itm.setmTitle(rss.getChannel().getItem().get(i).getTitle().getCdataSection());

            itm.setmImageURl(String.valueOf(rss.getChannel().getItem().get(i).getEnclosure().getUrl()));

            //realm.insertOrUpdate(itm);
            realm.copyToRealmOrUpdate(itm);

            realm.commitTransaction();

        }
    }

}
