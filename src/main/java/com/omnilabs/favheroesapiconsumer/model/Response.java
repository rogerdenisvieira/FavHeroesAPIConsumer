package com.omnilabs.favheroesapiconsumer.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    @JsonProperty("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
