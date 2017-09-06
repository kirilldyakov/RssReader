package ru.strongit.rssreader.model.rssModel;

import org.simpleframework.xml.Element;

public class Item {

        @Element(name="full-text", required=false)
        String fullText;
        //FullText fullText;

        @Element(name="enclosure", required=false)
        Enclosure enclosure;

        @Element(name="link", required=false)
        String link;

        @Element(name="description", required=false)
//        Description description;
        String description;

        @Element(name="guid", required=false)
        Guid guid;

        @Element(name="title", required=false)
        //Title title;
        String title;

        @Element(name="category", required=false)
        String category;

        @Element(name="pubDate", required=false)
        String pubDate;

//        public FullText getFullText() {return this.fullText;}
//        public void setFullText(FullText value) {this.fullText = value;}

        public String getFullText() {return this.fullText;}
        public void setFullText(String value) {this.fullText = value;}

        public Enclosure getEnclosure() {return this.enclosure;}
        public void setEnclosure(Enclosure value) {this.enclosure = value;}

        public String getLink() {return this.link;}
        public void setLink(String value) {this.link = value;}

//        public Description getDescription() {return this.description;}
//        public void setDescription(Description value) {this.description = value;}

        public String getDescription() {return this.description;}
        public void setDescription(String value) {this.description = value;}

        public Guid getGuid() {return this.guid;}
        public void setGuid(Guid value) {this.guid = value;}
//
//        public Title getTitle() {return this.title;}
//        public void setTitle(Title value) {this.title = value;}
//
        public String getTitle() {return this.title;}
        public void setTitle(String value) {this.title = value;}

        public String getCategory() {return this.category;}
        public void setCategory(String value) {this.category = value;}

        public String getPubDate() {return this.pubDate;}
        public void setPubDate(String value) {this.pubDate = value;}

    }