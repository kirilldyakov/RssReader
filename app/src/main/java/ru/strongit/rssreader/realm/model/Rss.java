package ru.strongit.rssreader.realm.model;

import javax.annotation.Generated;

import io.realm.RealmObject;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Rss extends RealmObject{

    private Channel mChannel;

    private Double mVersion;

    public Channel getChannel() {
        return mChannel;
    }

    public void setChannel(Channel channel) {
        mChannel = channel;
    }

    public Double getVersion() {
        return mVersion;
    }

    public void setVersion(Double version) {
        mVersion = version;
    }

}
