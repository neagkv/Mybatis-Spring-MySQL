package com.springrest.model.nyt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Results {

    int id;
    public String section;
    String subsection;
    String title;
    @JsonIgnoreProperties("abstract")
    String abstract_field;
    String url;
    String byline;
    String item_type;
    String updated_date;
    String created_date;
    String published_date;
    String material_type_facet;
    String kicker;
    String short_url;

    Multimedia[] multimedia;




    public Multimedia[] getMultimedia() {
        return multimedia;
    }


    public int getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public String getSubsection() {
        return subsection;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstract_field() {
        return abstract_field;
    }

    public String getUrl() {
        return url;
    }

    public String getByline() {
        return byline;
    }

    public String getItem_type() {
        return item_type;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public String getPublished_date() {
        return published_date;
    }

    public String getMaterial_type() {
        return material_type_facet;
    }

    public String getKicker() {
        return kicker;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setMultimedia(Multimedia[] multimedia) {
        this.multimedia = multimedia;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAbstract_field(String abstract_field) {
        this.abstract_field = abstract_field;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public void setMaterial_type(String material_type) {
        this.material_type_facet = material_type;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }


}
