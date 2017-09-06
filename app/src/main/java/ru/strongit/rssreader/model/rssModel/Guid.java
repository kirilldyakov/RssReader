package ru.strongit.rssreader.model.rssModel;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

public class Guid {

        @Text(required=false)
        String textValue;

        @Attribute(name="isPermaLink", required=false)
        Boolean isPermaLink;

        public String getTextValue() {return this.textValue;}
        public void setTextValue(String value) {this.textValue = value;}

        public Boolean getIsPermaLink() {return this.isPermaLink;}
        public void setIsPermaLink(Boolean value) {this.isPermaLink = value;}

    }