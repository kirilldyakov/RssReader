
package ru.strongit.rssreader.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Rss extends RealmObject{


    private Channel channel;

    @PrimaryKey
    private String version;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
