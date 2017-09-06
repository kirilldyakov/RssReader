package ru.strongit.rssreader.ui.descriptionActivity;

import android.content.Intent;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.strongit.rssreader.common.BasePresenter;
import ru.strongit.rssreader.realm.model.Item;

import static ru.strongit.rssreader.common.Constants.ITEM_ID_KEY;

/**
 * Created by user on 05.09.17.
 */


public class DescriptionActivityPresenter extends BasePresenter {
    String item_guid;
    Item item;

    private DescriptionActivity view() {
        return (DescriptionActivity) view;
    }

    public void init() {

        getDataFromIntent();

        getItemFromRealm();
    }

    private void getItemFromRealm() {


        if (item_guid == null) return;


        Realm realm = Realm.getDefaultInstance();







        RealmResults<Item> result23 = realm.where(Item.class)
//                .equalTo("name", "John")
//                .or()
//                .equalTo("name", "Peter")
                .findAll();


        try {
            //Item item = realm.where(Item.class).equalTo("mGuid", this.item_guid).findFirst();
            RealmResults<Item> result2 = realm.where(Item.class)
                    .equalTo("mGuid", "2336017101")//"item_guid")
                    .findAll();

            Item res = realm.where(Item.class)
                    .equalTo("mGuid", "2336017101")//"item_guid")
                    .findFirst();
            Item item = res;

            String title = res.getTitle();
            String guid = res.getGuid().getTextValue();
            String description = res.getDescription();
            String link = res.getLink();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            realm.close();
        }

    }

    void getDataFromIntent() {

        Intent intent = view.getIntent();

        this.item_guid = intent.getStringExtra(ITEM_ID_KEY);

    }
}
