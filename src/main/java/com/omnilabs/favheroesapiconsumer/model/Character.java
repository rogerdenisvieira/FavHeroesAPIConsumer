package com.omnilabs.favheroesapiconsumer.model;

public class Character {

    private Integer id;
    private String name;
    private String description;
    private String thumbnailPath;

    public Character(Integer id, String name, String description, String thumbnailPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                '}';
    }
}
