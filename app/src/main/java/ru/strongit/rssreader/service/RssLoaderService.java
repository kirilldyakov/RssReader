package ru.strongit.rssreader.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import static ru.strongit.rssreader.RssReaderApp.getAppContext;
import static ru.strongit.rssreader.realm.commands.ReamlCommands.getNewRssNews;


public class RssLoaderService extends Service {
    Timer timer = new Timer();
    TimerTask loadNewRss = new CustomTimerTask(getAppContext());

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "Service Started",  Toast.LENGTH_SHORT).show();

        timer.scheduleAtFixedRate(loadNewRss, 0, 10*60*1000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                getNewRssNews();
            }
        }, 1*60*1000);

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class CustomTimerTask extends TimerTask {
        private Context context;
        private Handler mHandler = new Handler();


        public CustomTimerTask(Context con) {
            this.context = con;
        }



        @Override
        public void run() {
            new Thread(new Runnable() {

                public void run() {

                    mHandler.post(new Runnable() {
                        public void run() {
                            getNewRssNews();
                        }
                    });
                }
            }).start();

        }
    }
}



