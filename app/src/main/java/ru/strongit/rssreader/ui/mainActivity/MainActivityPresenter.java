package ru.strongit.rssreader.ui.mainActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.widget.Toast;

import ru.strongit.rssreader.common.BasePresenter;
import ru.strongit.rssreader.service.RssLoaderService;

import static ru.strongit.rssreader.RssReaderApp.getAppContext;

/**
 * Created by user on 05.09.17.
 */

public class MainActivityPresenter extends BasePresenter {
private String TAG = "TAG";

    MainActivity view() {
        return (MainActivity) view;
    }

    public void init() {

        //getNewRssNews();
        startLoadService();

       // openDescriptionActivit("");
    }



    public void showScreenLandscape() {
        Toast.makeText(getAppContext(), "landscape", Toast.LENGTH_SHORT).show();
    }

    public void showScreenPortrait() {

        Toast.makeText(getAppContext(), "portrait", Toast.LENGTH_SHORT).show();
    }

    public void redrawScreen(Configuration newConfig) {
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showScreenLandscape();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            showScreenPortrait();
        }
    }

    private void startLoadService(){
        Intent intent = new Intent(getAppContext(), RssLoaderService.class);

//        Bundle bundle = new Bundle();
//
//        bundle.putString("","");
//
//        intent.putExtras(bundle);

        view().startService(intent);
    }

    public void openDescription() {
        openDescriptionActivit("2336373101");
    }
}
