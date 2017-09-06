
package ru.strongit.rssreader.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;


public class Channel extends RealmObject {

    private String description;

    private String docs;

    private String generator;

    private RealmList<Item> item;

    private String language;

    private String lastBuildDate;

    @Ignore
    private RealmList<Link> link;

    @PrimaryKey
    private String title;

    private String ttl;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public RealmList<Item> getItem() {
        return item;
    }

    public void setItem(RealmList<Item> item) {
        this.item = item;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public RealmList<Link> getLink() {
        return link;
    }

    public void setLink(RealmList<Link> link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
}
