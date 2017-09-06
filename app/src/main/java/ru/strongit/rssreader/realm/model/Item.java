
package ru.strongit.rssreader.realm.model;

import javax.annotation.Generated;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Item extends RealmObject {


    private String mCategory;

    private String mDescription;

//    private Enclosure mEnclosure;

    @PrimaryKey
    private String mGuid;

    private String mLink;

    private String mPubDate;

    private String mTitle;

    private String mImageURl;

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmGuid() {
        return mGuid;
    }

    public void setmGuid(String mGuid) {
        this.mGuid = mGuid;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public String getmPubDate() {
        return mPubDate;
    }

    public void setmPubDate(String mPubDate) {
        this.mPubDate = mPubDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmImageURl() {
        return mImageURl;
    }

    public void setmImageURl(String mImageURl) {
        this.mImageURl = mImageURl;
    }
}
