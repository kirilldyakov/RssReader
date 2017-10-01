package ru.strongit.rssreader.ui.mainActivity;

/**
 * Created by user on 01.10.17.
 */

interface IMainActivityPresenter {

    void detachView();

    void init();

    void startNewsLoading();

}
