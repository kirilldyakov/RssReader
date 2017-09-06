package ru.strongit.rssreader.common;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import ru.strongit.rssreader.ui.descriptionActivity.DescriptionActivity;
import ru.strongit.rssreader.ui.mainActivity.MainActivity;

import static ru.strongit.rssreader.RssReaderApp.getAppContext;
import static ru.strongit.rssreader.common.Constants.ITEM_ID_KEY;


/**
 * Created by user on 18.08.17.
 */

public abstract class BasePresenter {
    protected Activity view;

    public void attachView(AppCompatActivity activity) {
        this.view = activity;
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

        bundle.putString(ITEM_ID_KEY, itemID);

        intent.putExtras(bundle);

        view.startActivity(intent);
    }



    public void navItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case 1:
                break;
            case 2://R.id.nav_current_calls:
                openMainActivity("0");
                break;
            case 3://R.id.nav_arc_orders:
                openMainActivity("1");
                break;
//            case R.id.nav_light:
//                openLightOrderActivity();
//                break;
            case 4://R.id.nav_about:
                openMainActivity("2");
                break;
            default:
                break;
        }

    }
}
