package com.omnilabs.favheroesapiconsumer.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {

    @JsonProperty("data")
    private Data<T> data;

    public Data<T> getData() {
        return data;
    }

    public void setData(Data<T> data) {
        this.data = data;
    }
}
