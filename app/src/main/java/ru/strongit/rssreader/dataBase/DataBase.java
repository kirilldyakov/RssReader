package ru.strongit.rssreader.dataBase;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import ru.strongit.rssreader.dataBase.model.Channel;
import ru.strongit.rssreader.dataBase.model.Item;

/**
 * Created by user on 05.09.17.
 */

public class DataBase {
    private static String TAG = "TAG";

    public DataBase() {

        setOnChangeListener();

    }

    //Возвращает список новостей
    public static List<Item> getData() {

        List<Item> items = new ArrayList();

        Realm realm = Realm.getDefaultInstance();

        try {

            RealmResults<Item> realmResults = realm.where(Item.class).findAll();

            realmResults.load();

            items = realm.copyFromRealm(realmResults);


        } catch (Exception e) {

            return null;

        } finally {

            realm.close();

        }
        return items;
    }

    //Создает слушатель, следящий за изменени за изменениями в списке новостей
    private static void setOnChangeListener() {
        Realm realm = Realm.getDefaultInstance();

        try {


            RealmResults chanels = realm.where(Channel.class).findAll();

            chanels.addChangeListener(new RealmChangeListener<RealmResults>() {
                @Override
                public void onChange(RealmResults realmResults) {
                    Log.d(TAG, "onChange: Chanell");
                }
            });
                    
                    

            RealmResults items = realm.where(Item.class).findAll();
            
            items.addChangeListener(new RealmChangeListener<RealmResults>() {
                @Override
                public void onChange(RealmResults realmResults) {
                    Log.d(TAG, "onChange: Item"); 
                }
            });


            RealmResults<Item> item = realm.where(Item.class).findAllAsync();

            item.addChangeListener(new RealmChangeListener<RealmResults<Item>>() {

                @Override
                public void onChange(RealmResults<Item> items) {

                    Log.d(TAG, "onChange: ");

                }

            });
        } catch (Exception e) {

            Log.d(TAG, "RealmCommands: "+e.getMessage());

        } finally {

            realm.close();

        }
    }

    //Сохранияет полученный в виде json данные в базу данных
    public static void saveRssToRealm(String json) {

        Realm realm = Realm.getDefaultInstance();

        try {

            realm.beginTransaction();

            realm.createOrUpdateObjectFromJson(Channel.class, json);

            realm.commitTransaction();


        } catch (Exception e) {

            Log.d(TAG, "saveRssToRealm: " + e.getMessage());

        } finally {

            realm.close();

        }
    }

    //Возвращает количество новостей (Item)
    public static int getItemsCount() {

        Realm realm = Realm.getDefaultInstance();

        int cnt = 0;

        try {

            cnt = (int) realm.where(Item.class).count();

        } catch (Exception e) {

            Log.d(TAG, "getItemsCount: " + e.getMessage());

        } finally {

            realm.close();
        }

        return (int) cnt;
    }

    //Возвращает назваие загружаемого канала
    public static String getChannelName() {

        String result = null;

        Realm realm = Realm.getDefaultInstance();

        try {
            Channel channel = realm.where(Channel.class).findFirst();

            result = channel.getTitle();

        } catch (Exception e) {

            Log.d(TAG, "makeActivityTitle: " + e.getMessage());

        } finally {

            realm.close();
        }
        return result;
    }

}
