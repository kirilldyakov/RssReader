package ru.strongit.rssreader.model.rssModel;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.net.URL;
import java.util.List;

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

    public static class Item {

        @Element(name="full-text", required=false)
        FullText fullText;

        @Element(name="enclosure", required=false)
        Enclosure enclosure;

        @Element(name="link", required=false)
        String link;

        @Element(name="description", required=false)
        Description description;

        @Element(name="guid", required=false)
        Guid guid;

        @Element(name="title", required=false)
        Title title;

        @Element(name="category", required=false)
        String category;

        @Element(name="pubDate", required=false)
        String pubDate;

        public FullText getFullText() {return this.fullText;}
        public void setFullText(FullText value) {this.fullText = value;}

        public Enclosure getEnclosure() {return this.enclosure;}
        public void setEnclosure(Enclosure value) {this.enclosure = value;}

        public String getLink() {return this.link;}
        public void setLink(String value) {this.link = value;}

        public Description getDescription() {return this.description;}
        public void setDescription(Description value) {this.description = value;}

        public Guid getGuid() {return this.guid;}
        public void setGuid(Guid value) {this.guid = value;}

        public Title getTitle() {return this.title;}
        public void setTitle(Title value) {this.title = value;}

        public String getCategory() {return this.category;}
        public void setCategory(String value) {this.category = value;}

        public String getPubDate() {return this.pubDate;}
        public void setPubDate(String value) {this.pubDate = value;}

    }

    public static class Enclosure {

        @Attribute(name="length", required=false)
        Integer length;

        @Attribute(name="type", required=false)
        String type;

        @Attribute(name="url", required=false)
        URL url;

        public Integer getLength() {return this.length;}
        public void setLength(Integer value) {this.length = value;}

        public String getType() {return this.type;}
        public void setType(String value) {this.type = value;}

        public URL getUrl() {return this.url;}
        public void setUrl(URL value) {this.url = value;}

    }

    public static class Channel {

        @ElementList(name="item", required=false, entry="item", inline=true)
        List<Item> item;

//        @Text(required=false)
//        String textValue;

        @Element(name="docs", required=false)
        String docs;

        @Element(name="lastBuildDate", required=false)
        String lastBuildDate;

        @ElementList(name="link", required=false, entry="link", inline=true)
        List<Link> link;

        @Element(name="generator", required=false)
        String generator;

        @Element(name="description", required=false)
        String description;

        @Element(name="language", required=false)
        String language;

        @Element(name="title", required=false)
        String title;

        @Element(name="ttl", required=false)
        String ttl;

        public List<Item> getItem() {return this.item;}
        public void setItem(List<Item> value) {this.item = value;}

//        public String getTextValue() {return this.textValue;}
//        public void setTextValue(String value) {this.textValue = value;}

        public String getDocs() {return this.docs;}
        public void setDocs(String value) {this.docs = value;}

        public String getLastBuildDate() {return this.lastBuildDate;}
        public void setLastBuildDate(String value) {this.lastBuildDate = value;}

        public List<Link> getLink() {return this.link;}
        public void setLink(List<Link> value) {this.link = value;}

        public String getGenerator() {return this.generator;}
        public void setGenerator(String value) {this.generator = value;}

        public String getDescription() {return this.description;}
        public void setDescription(String value) {this.description = value;}

        public String getLanguage() {return this.language;}
        public void setLanguage(String value) {this.language = value;}

        public String getTitle() {return this.title;}
        public void setTitle(String value) {this.title = value;}

        public String getTtl() {return this.ttl;}
        public void setTtl(String value) {this.ttl = value;}

    }

    public static class Link {

        @Attribute(name="rel", required=false)
        String rel;

        @Attribute(name="href", required=false)
        URL href;

        @Attribute(name="type", required=false)
        String type;

        public String getRel() {return this.rel;}
        public void setRel(String value) {this.rel = value;}

        public URL getHref() {return this.href;}
        public void setHref(URL value) {this.href = value;}

        public String getType() {return this.type;}
        public void setType(String value) {this.type = value;}

    }

    public static class Description {

        @Element(name="#cdata-section", required=false)
        String cdataSection;

        public String getCdataSection() {return this.cdataSection;}
        public void setCdataSection(String value) {this.cdataSection = value;}

    }

    public static class Guid {

        @Text(required=false)
        String textValue;

        @Attribute(name="isPermaLink", required=false)
        Boolean isPermaLink;

        public String getTextValue() {return this.textValue;}
        public void setTextValue(String value) {this.textValue = value;}

        public Boolean getIsPermaLink() {return this.isPermaLink;}
        public void setIsPermaLink(Boolean value) {this.isPermaLink = value;}

    }

    public static class Title {

        @Element(name="#cdata-section", required=false)
        String cdataSection;

        public String getCdataSection() {return this.cdataSection;}
        public void setCdataSection(String value) {this.cdataSection = value;}

    }

}