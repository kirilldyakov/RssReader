package ru.strongit.rssreader.ui.descriptionActivity;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;

import io.realm.Realm;
import ru.strongit.rssreader.dataBase.model.Item;

import static ru.strongit.rssreader.common.Constants.ITEM_GUID_KEY;


public class DescriptionActivityPresenter {
    private String item_guid;
    private Item item;

    protected IDescriptionActivity view;

    protected DescriptionActivityPresenter(DescriptionActivity view) {
        this.view = view;
    }

    void init() {

        getDataFromIntent();

        getItemFromRealm();

        bindItem();
    }

    private void bindItem() {

        view.fillTitle(item.getTitle());

        view.fillFullText(Html.fromHtml(item.getFullText()));

        //view().tvLink.setText(item.getLink());
    }

    private void getDataFromIntent() {

        Intent intent = view.getIntent();

        this.item_guid = intent.getStringExtra(ITEM_GUID_KEY);

    }

    private void getItemFromRealm() {

        if (item_guid == null) return;

        Realm realm = Realm.getDefaultInstance();

        try {

            Item res = realm.where(Item.class)
                    .equalTo("guid.textValue", item_guid)
                    .findFirst();

            item = realm.copyFromRealm(res);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            realm.close();

        }

    }


    void openWWWurl() {

        String url = item.getLink();

        Uri uriUrl = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);

        view.startWWW(intent);

    }
}
