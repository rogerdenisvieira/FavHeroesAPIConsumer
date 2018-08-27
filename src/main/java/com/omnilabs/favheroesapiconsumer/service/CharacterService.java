package com.omnilabs.favheroesapiconsumer.service;

import com.omnilabs.favheroesapiconsumer.model.Character;
import com.omnilabs.favheroesapiconsumer.factory.MarvelURIFactory;
import com.omnilabs.favheroesapiconsumer.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

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

        ResponseEntity<Response<CharacterResult>> response = template.exchange(
                marvelURIFactory.getCharactersURI(id).toString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Response<CharacterResult>>() {}
        );

        CharacterResult characterResult = response.getBody().getData().getResults().get(0);

        Character character = new Character(
                characterResult.getId(),
                characterResult.getName(),
                characterResult.getDescription(),
                characterResult.getThumbnail().getPath()
        );

        LOG.info("Character: {}", character.toString());

        return character;
    }

}
