
package ru.strongit.rssreader.realm.model;

import javax.annotation.Generated;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Channel extends RealmObject {

    @PrimaryKey
    private String mDescription;

    private String mDocs;

    private String mGenerator;

    private RealmList<Item> mItem;

    private String mLanguage;

    private String mLastBuildDate;

    private RealmList<Link> mLink;

    private String mTitle;

    private String mTtl;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDocs() {
        return mDocs;
    }

    public void setDocs(String docs) {
        mDocs = docs;
    }

    public String getGenerator() {
        return mGenerator;
    }

    public void setGenerator(String generator) {
        mGenerator = generator;
    }

    public RealmList<Item> getItem() {
        return mItem;
    }

    public void setItem(RealmList<Item> item) {
        mItem = item;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getLastBuildDate() {
        return mLastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        mLastBuildDate = lastBuildDate;
    }

    public RealmList<Link> getLink() {
        return mLink;
    }

    public void setLink(RealmList<Link> link) {
        mLink = link;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTtl() {
        return mTtl;
    }

    public void setTtl(String ttl) {
        mTtl = ttl;
    }

}
