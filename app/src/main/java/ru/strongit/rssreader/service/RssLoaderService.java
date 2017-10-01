package ru.strongit.rssreader.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import static ru.strongit.rssreader.RssReaderApp.getAppContext;
import static ru.strongit.rssreader.network.NetLoader.loadRssNewsFromWWW;


public class RssLoaderService extends Service {
    String TAG = "TAG";

    Timer timer = new Timer();

    TimerTask loadRssTimerTask = new CustomTimerTask(getAppContext());

    @Override
    public void onCreate() {

        Log.d(TAG, "onCreate: " + "Запущен сервис");

        super.onCreate();

        int timer_delay = 10;

        long timer_period = 10 * 60 * 1000;

        timer.scheduleAtFixedRate(loadRssTimerTask, timer_delay, timer_period);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        long handlerRunDelay = 1 * 60 * 1000; // 1 раз в минуту

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                loadRssNewsFromWWW();

            }

        }, handlerRunDelay);

        // сервис будет перезапущен после того, как был убит системой
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

    //Выплнение задачи по таймеру
    private class CustomTimerTask extends TimerTask {

        Context context;

        Handler mHandler = new Handler();

        public CustomTimerTask(Context con) {
            this.context = con;
        }

        @Override
        public void run() {
            new Thread(new Runnable() {
                public void run() {
                    mHandler.post(new Runnable() {
                        public void run() {
                            loadRssNewsFromWWW();
                        }
                    });
                }
            }).start();

        }
    }
}



