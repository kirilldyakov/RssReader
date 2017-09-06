
package ru.strongit.rssreader.realm.model;

import io.realm.annotations.PrimaryKey;


public class Guid {


    private Boolean mIsPermaLink;

    @PrimaryKey
    private String mTextValue;

    public Boolean getIsPermaLink() {
        return mIsPermaLink;
    }

    public void setIsPermaLink(Boolean isPermaLink) {
        mIsPermaLink = isPermaLink;
    }

    public String getTextValue() {
        return mTextValue;
    }

    public void setTextValue(String textValue) {
        mTextValue = textValue;
    }

}
