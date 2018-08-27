package com.omnilabs.favheroesapiconsumer.service;

import com.omnilabs.favheroesapiconsumer.factory.MarvelURIFactory;
import com.omnilabs.favheroesapiconsumer.model.Comic;
import com.omnilabs.favheroesapiconsumer.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.List;

public class ComicService {

    private static final Logger LOG = LoggerFactory.getLogger(CharacterService.class);

    private MarvelURIFactory marvelURIFactory;

    public ComicService(MarvelURIFactory marvelURIFactory) {
        this.marvelURIFactory = marvelURIFactory;
    }

    public List<Comic> findTopComicsByCharacterId(Integer characterId, Integer limit) throws URISyntaxException {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Response> response = template.exchange(
                marvelURIFactory.getComicsURI(characterId, limit).toString(),
                HttpMethod.GET,
                entity,
                Response.class
        );

        //TODO you MUST to implment it
        return null;

    }

}
