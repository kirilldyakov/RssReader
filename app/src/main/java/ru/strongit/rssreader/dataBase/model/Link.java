
package ru.strongit.rssreader.dataBase.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Link extends RealmObject{

    @PrimaryKey
    private String href;

    private String rel;

    private String type;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
