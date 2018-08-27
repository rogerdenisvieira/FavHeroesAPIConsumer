package com.omnilabs.favheroesapiconsumer.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FavHeroesAPIConsumerProperties {


    @Value("${application.uri.root}")
    private String rootURI;

    @Value("${application.api.key.public}")
    private String publicKey;

    @Value("${application.api.key.private}")
    private String privateKey;

    public String getHost() {
        return rootURI;
    }

    public void setHost(String rootURI) {
        this.rootURI = rootURI;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
