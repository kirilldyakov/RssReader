package ru.strongit.rssreader.ui.mainActivity;

import android.content.Intent;

import java.util.List;

import ru.strongit.rssreader.ItemAdapter;
import ru.strongit.rssreader.dataBase.model.Item;

/**
 * Created by user on 01.10.17.
 */

interface IMainActivity {
    void startActivity(Intent intent);


    void setNewsTitle(String title);

    void setNewsText(String description);

    void showProgress();

    void hideProgress();

    void bindData(List<Item> items, ItemAdapter.OnItemClickListener listener);

    void startLoadService();

    void showMessage(String message);
}
