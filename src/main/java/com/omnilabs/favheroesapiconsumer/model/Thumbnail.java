package com.omnilabs.favheroesapiconsumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Thumbnail {

    private final String THUMBNAIL_SIZE = "standard_xlarge";

    @JsonProperty("path")
    private String path;

    @JsonProperty("extension")
    private String extension;

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path
                + "/"
                + THUMBNAIL_SIZE
                + "."
                + extension;
    }
}
