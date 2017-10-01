package ru.strongit.rssreader.model.rssModel;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="rss")
public class Rss {

    @Element(name="channel", required=false)
    Channel channel;

    @Attribute(name="version", required=false)
    Double version;

    public Channel getChannel() {return this.channel;}
    public void setChannel(Channel value) {this.channel = value;}

    public Double getVersion() {return this.version;}

    public void setVersion(Double value) {this.version = value;}

    public static class FullText {

        @Element(name="#cdata-section", required=false)
        String cdataSection;

        public String getCdataSection() {return this.cdataSection;}
        public void setCdataSection(String value) {this.cdataSection = value;}

    }


}