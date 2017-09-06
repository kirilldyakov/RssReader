package ru.strongit.rssreader.model.rssModel;

import org.simpleframework.xml.Attribute;

import java.net.URL;

public class Link {

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