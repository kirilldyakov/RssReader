package ru.strongit.rssreader.model.rssModel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class Channel {

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