package com.omnilabs.favheroesapiconsumer.service;

import com.google.gson.Gson;
import com.omnilabs.favheroesapiconsumer.controller.MainController;
import com.omnilabs.favheroesapiconsumer.factory.MarvelURIFactory;
import com.omnilabs.favheroesapiconsumer.model.Character;
import com.omnilabs.favheroesapiconsumer.model.Response;

import com.omnilabs.favheroesapiconsumer.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class CharacterService {

    private static final Logger LOG = LoggerFactory.getLogger(CharacterService.class);

    private MarvelURIFactory marvelURIFactory;


    @Autowired
    public CharacterService(MarvelURIFactory marvelURIFactory) {
        this.marvelURIFactory = marvelURIFactory;
    }

    public Character getCharacterByID(int id) throws URISyntaxException {

        LOG.info(String.format("Retrieving character with ID %s", id));

        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Response> response = template.exchange(
                marvelURIFactory.getCharactersURI(id).toString(),
                HttpMethod.GET,
                entity,
                Response.class
        );

        Result result = response.getBody().getData().getResults().get(0);

        Character character = new Character(
                result.getName(),
                result.getDescription()
        );

        return character;
    }

}
