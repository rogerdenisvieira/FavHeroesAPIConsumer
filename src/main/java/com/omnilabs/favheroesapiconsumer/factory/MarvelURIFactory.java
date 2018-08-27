package com.omnilabs.favheroesapiconsumer.factory;

import com.omnilabs.favheroesapiconsumer.controller.MainController;
import com.omnilabs.favheroesapiconsumer.properties.FavHeroesAPIConsumerProperties;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;

@Component
public class MarvelURIFactory {

    private static final Logger LOG = LoggerFactory.getLogger(MarvelURIFactory.class);
    private FavHeroesAPIConsumerProperties favHeroesAPIConsumerProperties;
    private final String PROTOCOL = "http";


    @Autowired
    public MarvelURIFactory(FavHeroesAPIConsumerProperties favHeroesAPIConsumerProperties) {
        this.favHeroesAPIConsumerProperties = favHeroesAPIConsumerProperties;

    }

    public URI getCharactersURI(Integer id) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder();

        URI uri = uriBuilder
                .setScheme(PROTOCOL)
                .setHost(favHeroesAPIConsumerProperties.getHost())
                .setPath(String.format("/characters/%s", id.toString()))
                .addParameter("ts", getTimeStamp())
                .addParameter("apikey", favHeroesAPIConsumerProperties.getPublicKey())
                .addParameter("hash", getHash())
                .build();


        LOG.info("Character URI built: {}", uri.toString());
        return uri;
    }

    public URI getComicsURI(Integer characterId, Integer limit) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder();

        URI uri = uriBuilder
                .setScheme(PROTOCOL)
                .setHost(favHeroesAPIConsumerProperties.getHost())
                .setPath(String.format("/characters/%s/comics", characterId))
                .addParameter("limit", limit.toString())
                .addParameter("ts", getTimeStamp())
                .addParameter("apikey", favHeroesAPIConsumerProperties.getPublicKey())
                .addParameter("hash", getHash())
                .build();

        LOG.info("Comic URI built: {}", uri.toString());
        return uri;
    }

    private String getHash() {
        String publicKey = favHeroesAPIConsumerProperties.getPublicKey();
        String privateKey = favHeroesAPIConsumerProperties.getPrivateKey();
        String timeStamp = getTimeStamp();

        String md5Hex = DigestUtils
                .md5Hex(timeStamp + privateKey + publicKey);

        return md5Hex;
    }

    //FIXME refactory to retrieve a true timestamp, not a hardcoded number such as coded below
    private String getTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "9";
    }

}

