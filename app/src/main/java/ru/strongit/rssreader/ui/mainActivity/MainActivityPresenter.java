package ru.strongit.rssreader.ui.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.List;

import ru.strongit.rssreader.ItemAdapter;
import ru.strongit.rssreader.common.Constants;
import ru.strongit.rssreader.dataBase.DataBase;
import ru.strongit.rssreader.dataBase.model.Item;
import ru.strongit.rssreader.network.NetLoader;
import ru.strongit.rssreader.network.OnDataLoadedListener;
import ru.strongit.rssreader.ui.descriptionActivity.DescriptionActivity;

import static ru.strongit.rssreader.RssReaderApp.getAppContext;
import static ru.strongit.rssreader.common.Constants.ITEM_GUID_KEY;
import static ru.strongit.rssreader.dataBase.DataBase.getData;
import static ru.strongit.rssreader.dataBase.DataBase.saveRssToRealm;


/**
 * Created by user on 05.09.17.
 */

public class MainActivityPresenter implements IMainActivityPresenter, MyListener {
    private String TAG = "TAG";

    private ItemAdapter.OnItemClickListener listener;

    private String scrOrnt = Constants.ORIENTATION_PORTRAIT;;

    IMainActivity view;

    NetLoader net;

    public MainActivityPresenter(MainActivity view) {
        this.view = view;

        //this.db = new IDataBase();

        this.net = new NetLoader();
    }


    public void detachView() {
        this.view = null;
    }

    protected void openMainActivity(String orderID) {
        Intent intent = new Intent(getAppContext(), MainActivity.class);
//
//        Bundle bundle = new Bundle();
//
//        bundle.putString(CALL_ID_KEY, orderID);
//
//        intent.putExtras(bundle);
//
        view.startActivity(intent);
    }

    protected void openDescriptionActivit(String itemID) {
        Intent intent = new Intent(getAppContext(), DescriptionActivity.class);

        Bundle bundle = new Bundle();

        bundle.putString(ITEM_GUID_KEY, itemID);

        intent.putExtras(bundle);

        view.startActivity(intent);
    }



    @Override
    public void init() {

        view.startLoadService();

        initListener();

        initViews();

        initNetworkEvents();
    }

    private void initNetworkEvents() {

        net.setOnEventListener(new OnDataLoadedListener() {
            @Override
            public void onDataLoadetEvent(String Json) {

                saveRssToRealm(Json);

                view.hideProgress();

            }
        });
    }

    private void initViews() {
        setActivityTitle();

        List<Item> itemList = getData();

        if (itemList!=null)

            view.bindData(itemList, listener);
    }

    private void initListener() {

        listener = new ItemAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(Item item) {
                try {
                    String guid = item.getGuid().getTextValue();

                    if (!TextUtils.isEmpty(guid))

                        if (scrOrnt.equals(Constants.ORIENTATION_PORTRAIT))

                            openDescriptionActivit(guid);

                        else

                            view.setNewsText(item.getFullText());

                } catch (Exception e) {

                    e.printStackTrace();

                }
            }
        };

    }


    private void setActivityTitle() {

        String title = DataBase.getChannelName();

        if (TextUtils.isEmpty(title)) title = "Новости";

        view.setNewsTitle(title);

    }


    @Override
    public void startNewsLoading() {

        NetLoader.loadRssNewsFromWWW();

    }

    @Override
    public void onNewsLoaded(String data) {

        saveRssToRealm(data);

        view.hideProgress();

    }

}
