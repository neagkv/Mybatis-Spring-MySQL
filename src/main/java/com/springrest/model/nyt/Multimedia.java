package com.springrest.model.nyt;

public class Multimedia {

    String url;
    int top_story_id;
    String format;
    int height;
    int width;
    String type;
    String subtype;
    String copyright;
    String caption;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getTop_story_id() {
        return top_story_id;
    }

    public void setTop_story_id(int top_story_id) {
        this.top_story_id = top_story_id;
    }

    public String getUrl() {
        return url;
    }

    public String getFormat() {
        return format;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
