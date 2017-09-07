package ru.strongit.rssreader.ui.mainActivity;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.strongit.rssreader.ItemAdapter;
import ru.strongit.rssreader.common.BasePresenter;
import ru.strongit.rssreader.common.Constants;
import ru.strongit.rssreader.realm.model.Channel;
import ru.strongit.rssreader.realm.model.Item;
import ru.strongit.rssreader.service.RssLoaderService;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static ru.strongit.rssreader.RssReaderApp.getAppContext;
import static ru.strongit.rssreader.realm.commands.ReamlCommands.getNewRssNews;

/**
 * Created by user on 05.09.17.
 */

public class MainActivityPresenter extends BasePresenter {
    private String TAG = "TAG";

    private List<Item> itemList;

    private ItemAdapter.OnItemClickListener listener;

    private String scrOrnt;

    public MainActivityPresenter() {
        this.itemList = new ArrayList<>();
    }

    MainActivity view() {
        return (MainActivity) view;
    }

    public void init() {

        makeActivityTitle();

        scrOrnt = Constants.ORIENTATION_PORTRAIT;

        initListener();

        startLoadService();

        if (getData())

            bindData(itemList);

    }

    private void makeActivityTitle() {
        String title = "Новости";
        Realm realm = Realm.getDefaultInstance();
        try{
            Channel channel = realm.where(Channel.class).findFirst();

            title = channel.getTitle();
        }
        catch (Exception e){}
        finally {
            realm.close();
        }
        view().setTitle(title);

    }

    private void initListener() {

        listener = new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
                try {

                    String guid = item.getGuid().getTextValue();
                    if(scrOrnt == Constants.ORIENTATION_PORTRAIT)
                        openDescriptionActivit(guid);
                    else
                        showDescription(item.getFullText());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

    }

    private void showDescription(String description) {
        if(view().tvDescription != null)
            view().tvDescription.setText(Html.fromHtml(description));
    }


    private void bindData(List<Item> items) {

        try {

            ItemAdapter adapter = new ItemAdapter(getAppContext(), items, listener);

            view().recItems.setAdapter(adapter);

            view().recItems.setItemAnimator(new DefaultItemAnimator());

            view().recItems.setAdapter(adapter);

            adapter.notifyDataSetChanged();


        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    private boolean getData() {

        Realm realm = Realm.getDefaultInstance();

        try {

            RealmResults<Item> realmResults = realm.where(Item.class).findAll();

            realmResults.load();

            itemList = realm.copyFromRealm(realmResults);


        } catch (Exception e) {
            return false;

        } finally {
            realm.close();
        }
        return true;
    }

//    private void showScreenLandscape() {
//        Toast.makeText(getAppContext(), "landscape", Toast.LENGTH_SHORT).show();
//        scrOrnt = Constants.ORIENTATION_LANDSCAPE;
//    }
//
//    private void showScreenPortrait() {
//
//        scrOrnt = Constants.ORIENTATION_PORTRAIT;
//
//        Toast.makeText(getAppContext(), "portrait", Toast.LENGTH_SHORT).show();
//    }
//
//    void redrawScreen(Configuration newConfig) {
//        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            showScreenLandscape();
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            showScreenPortrait();
//        }
//    }


    private void startLoadService() {
        Intent intent = new Intent(getAppContext(), RssLoaderService.class);

        view().startService(intent);
    }



    public void startRefreshing() {
        try {
            getNewRssNews();
            init();
        } catch (Exception e) {
        }
        finally {
            stopRefreshing();
        }

    }

    public void stopRefreshing() {

        view().swipeRefreshLayout.setRefreshing(false);

    }

    public void defineOrientation(int orientation) {
        if (orientation == ORIENTATION_LANDSCAPE)
            scrOrnt = Constants.ORIENTATION_LANDSCAPE;
        else
            scrOrnt = Constants.ORIENTATION_PORTRAIT;

    }
}
