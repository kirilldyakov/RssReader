package ru.strongit.rssreader.model.rssModel;

import org.simpleframework.xml.Attribute;

import java.net.URL;

public class Enclosure {

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