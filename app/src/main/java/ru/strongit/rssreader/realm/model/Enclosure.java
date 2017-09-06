
package ru.strongit.rssreader.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Enclosure extends RealmObject{

    private Long length;

    private String type;

    @PrimaryKey
    private String url;

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
