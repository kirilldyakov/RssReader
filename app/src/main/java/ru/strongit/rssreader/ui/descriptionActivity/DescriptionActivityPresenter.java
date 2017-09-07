package ru.strongit.rssreader.ui.descriptionActivity;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;

import io.realm.Realm;
import ru.strongit.rssreader.common.BasePresenter;
import ru.strongit.rssreader.realm.model.Item;

import static ru.strongit.rssreader.common.Constants.ITEM_GUID_KEY;


public class DescriptionActivityPresenter extends BasePresenter {
    String item_guid;
    Item item;

    private DescriptionActivity view() {
        return (DescriptionActivity) view;
    }

    public void init() {

        getDataFromIntent();

        getItemFromRealm();

        bindItem();
    }

    private void bindItem() {

        view().setTitle(item.getTitle());

        view().tvFullText.setText(Html.fromHtml(item.getFullText()));
        //view().tvLink.setText(item.getLink());
    }

    void getDataFromIntent() {

        Intent intent = view.getIntent();

        this.item_guid = intent.getStringExtra(ITEM_GUID_KEY);

    }

    private void getItemFromRealm() {

        if (item_guid == null) return;

        Realm realm = Realm.getDefaultInstance();

        try {
            //Item item = realm.where(Item.class).equalTo("mGuid", this.item_guid).findFirst();
            Item res = realm.where(Item.class)
                    .equalTo("guid.textValue", item_guid)//"item_guid")
                    .findFirst();
            //Неправольныый подход
            item = new Item();
            item.setTitle(res.getTitle());
            item.setEnclosure(res.getEnclosure());
            item.setDescription(res.getDescription());
            item.setLink(res.getLink());
            item.setFullText(res.getFullText());
            item.setPubDate(res.getPubDate());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            realm.close();
        }

    }


    public void www() {
        String url = item.getLink();
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        view().startActivity(launchBrowser);
    }
}
