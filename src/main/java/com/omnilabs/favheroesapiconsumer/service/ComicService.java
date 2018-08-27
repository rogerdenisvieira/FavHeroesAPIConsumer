package com.omnilabs.favheroesapiconsumer.service;

import com.omnilabs.favheroesapiconsumer.factory.MarvelURIFactory;
import com.omnilabs.favheroesapiconsumer.model.Comic;
import com.omnilabs.favheroesapiconsumer.model.ComicResult;
import com.omnilabs.favheroesapiconsumer.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComicService {

    private static final Logger LOG = LoggerFactory.getLogger(ComicService.class);

    private MarvelURIFactory marvelURIFactory;

    public ComicService(MarvelURIFactory marvelURIFactory) {
        this.marvelURIFactory = marvelURIFactory;
    }

    public List<Comic> findTopComicsByCharacterId(Integer characterId, Integer limit) throws URISyntaxException {

        List<Comic> comics = new ArrayList<>();
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Response<ComicResult>> response = template.exchange(
                marvelURIFactory.getComicsURI(characterId, limit).toString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Response<ComicResult>>() {
                }
        );

        List<ComicResult> comicResults = response.getBody().getData().getResults();

        for (ComicResult comicResult : comicResults) {
            comics.add(new Comic(
                    comicResult.getId(),
                    comicResult.getTitle(),
                    comicResult.getDescription(),
                    comicResult.getThumbnail().getPath()));
        }


        for (Comic comic : comics) {
            LOG.info("Comic: {}", comic);
        }

        return comics;

    }

}
