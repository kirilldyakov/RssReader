
package ru.strongit.rssreader.realm.model;

import javax.annotation.Generated;

import io.realm.RealmObject;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Link extends RealmObject{


    private String mHref;

    private String mRel;

    private String mType;

    public String getHref() {
        return mHref;
    }

    public void setHref(String href) {
        mHref = href;
    }

    public String getRel() {
        return mRel;
    }

    public void setRel(String rel) {
        mRel = rel;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
