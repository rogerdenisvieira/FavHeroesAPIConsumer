package com.omnilabs.favheroesapiconsumer.factory;

import com.omnilabs.favheroesapiconsumer.properties.FavHeroesAPIConsumerProperties;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;

@Component
public class MarvelURIFactory {

    private FavHeroesAPIConsumerProperties favHeroesAPIConsumerProperties;

    private final String PROTOCOL = "http";


    @Autowired
    public MarvelURIFactory(FavHeroesAPIConsumerProperties favHeroesAPIConsumerProperties) {
        this.favHeroesAPIConsumerProperties = favHeroesAPIConsumerProperties;

    }

    public URI getCharactersURI(Integer id) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder
                .setScheme(PROTOCOL)
                .setHost(favHeroesAPIConsumerProperties.getHost())
                .setPath(String.format("/characters/%s", id.toString()))
                .addParameter("ts", getTimeStamp())
                .addParameter("apikey", favHeroesAPIConsumerProperties.getPublicKey())
                .addParameter("hash", getHash());

        return uriBuilder.build();
    }

    public URI getComicsURI(Integer characterId, Integer limit) throws URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder();

        uriBuilder
                .setScheme(PROTOCOL)
                .setHost(favHeroesAPIConsumerProperties.getHost())
                .setPath(String.format("/characters/%s/comics", characterId))
                .addParameter("limit", limit.toString())
                .addParameter("ts", getTimeStamp())
                .addParameter("apikey", favHeroesAPIConsumerProperties.getPublicKey())
                .addParameter("hash", getHash());

        return uriBuilder.build();
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

