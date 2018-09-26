package com.radio.search_fm.entities;

import java.util.List;

public class Artist {
    private String name;
    private String mbid;
    private String url;
    private String image_small;
    private int streamable;
    private List<Image> image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_small() {
        return image_small;
    }

    public void setImage_small(String image_small) {
        this.image_small = image_small;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public int getStreamable() {
        return streamable;
    }

    public void setStreamable(int streamable) {
        this.streamable = streamable;
    }
}
