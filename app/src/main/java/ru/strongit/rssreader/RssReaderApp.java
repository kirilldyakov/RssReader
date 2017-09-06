package ru.strongit.rssreader;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;


import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;

//import io.fabric.sdk.android.Fabric;



public class RssReaderApp extends Application {

    //public static final String API_BASE_URL = "https://lenta.ru";

    public static final String API_BASE_URL = "http://www.aif.ru/";


    private static Context context;

    //public static DataHelper dataHelper;


    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();


        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

//        try {
//            Realm realm = Realm.getDefaultInstance();
//            realm.close();
//            Realm.deleteRealm(realm.getConfiguration());
//            //Realm file has been deleted.
//        } catch (Exception ex){
//            ex.printStackTrace();
//            //No Realm file to remove.
//        }

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        //.enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());


    }

    public static class OkHttpClientBuilder {
        protected static OkHttpClient configureClient() {
            OkHttpClient client = null;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(180, TimeUnit.SECONDS);
            builder.addNetworkInterceptor(new StethoInterceptor());
            client = builder.build();
            return client;
        }

        public static OkHttpClient createClient() {
            return configureClient();
        }
    }


    public static Context getAppContext() {
        return context;
    }



}
