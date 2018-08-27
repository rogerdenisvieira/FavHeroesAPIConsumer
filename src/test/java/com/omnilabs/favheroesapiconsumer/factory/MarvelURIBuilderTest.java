package com.omnilabs.favheroesapiconsumer.factory;

import com.omnilabs.favheroesapiconsumer.properties.FavHeroesAPIConsumerProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import java.net.URISyntaxException;

public class MarvelURIBuilderTest {

    private final String CHARACTERS_URI = "http://gateway.marvel.com/v1/public/characters/1009368?ts=9&apikey=2f39ab6a819f27d7e244b744fef9d156&hash=eddd7fa2df5a8ba6e3ad1bca2700491a";
    private final String COMICS_URI = "http://gateway.marvel.com/v1/public/characters/1009368/comics?limit=5&ts=9&apikey=2f39ab6a819f27d7e244b744fef9d156&hash=eddd7fa2df5a8ba6e3ad1bca2700491a";
    private final Integer CHARACTER_ID = 1009368;
    private final String PUBLIC_KEY = "2f39ab6a819f27d7e244b744fef9d156";
    private final String PRIVATE_KEY = "a5fd05492f7f9680ec7b95ee44239fd166009ef8";
    private final String HOST = "gateway.marvel.com/v1/public";
    private final Integer COMICS_LIMIT = 5;

    private FavHeroesAPIConsumerProperties favHeroesAPIConsumerPropertiesMock;
    private MarvelURIFactory marvelURIFactory;


    @Before
    public void setup() {
        favHeroesAPIConsumerPropertiesMock = Mockito.mock(FavHeroesAPIConsumerProperties.class);
        Mockito.when(favHeroesAPIConsumerPropertiesMock.getPublicKey()).thenReturn(PUBLIC_KEY);
        Mockito.when(favHeroesAPIConsumerPropertiesMock.getPrivateKey()).thenReturn(PRIVATE_KEY);
        Mockito.when(favHeroesAPIConsumerPropertiesMock.getHost()).thenReturn(HOST);
        marvelURIFactory = new MarvelURIFactory(favHeroesAPIConsumerPropertiesMock);

    }

    @Test
    public void testCharactersURI() throws URISyntaxException {
        Assert.assertEquals(CHARACTERS_URI, marvelURIFactory.getCharactersURI(CHARACTER_ID).toString());

    }

    @Test
    public void testComicsURI() throws URISyntaxException {
        Assert.assertEquals(COMICS_URI, marvelURIFactory.getComicsURI(CHARACTER_ID, COMICS_LIMIT).toString());
    }
}
