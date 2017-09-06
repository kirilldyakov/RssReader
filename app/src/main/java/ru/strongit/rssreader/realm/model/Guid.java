
package ru.strongit.rssreader.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Guid extends RealmObject{


    private Boolean isPermaLink;

    @PrimaryKey
    private String textValue;

    public Boolean getPermaLink() {
        return isPermaLink;
    }

    public void setPermaLink(Boolean permaLink) {
        isPermaLink = permaLink;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }
}
