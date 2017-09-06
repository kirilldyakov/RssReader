package ru.strongit.rssreader.model.rssModel;

import org.simpleframework.xml.Element;

public class Description {

        @Element(name="#cdata-section", required=false)
        String cdataSection;

        public String getCdataSection() {return this.cdataSection;}
        public void setCdataSection(String value) {this.cdataSection = value;}

    }