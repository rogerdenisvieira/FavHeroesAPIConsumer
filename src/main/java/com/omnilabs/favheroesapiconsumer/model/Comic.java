package com.omnilabs.favheroesapiconsumer.model;

public class Comic {

    private Integer id;
    private String title;
    private String description;
    private String thumbnailPath;

    public Comic(Integer id, String title, String description, String thumbnailPath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                '}';
    }
}
