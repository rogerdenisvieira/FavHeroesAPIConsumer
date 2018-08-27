package com.omnilabs.favheroesapiconsumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data<T> {

    @JsonProperty("results")
    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
