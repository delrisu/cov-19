package com.delrisu.pcsscovid.service;

import com.delrisu.pcsscovid.model.LatestLithuania;
import com.delrisu.pcsscovid.model.LatestPolandData;
import com.delrisu.pcsscovid.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service("apifyService")
public class ApifyService {

    private final WebClient webClient;

    private Logger logger = LoggerFactory.getLogger(ApifyService.class);

    private final String LATEST = "/records/LATEST?disableRedirect=true";
    private final String KEY_VALUE_STORES = "/key-value-stores";

    public ApifyService() {
        this.webClient = WebClient.builder().baseUrl("https://api.apify.com/v2").build();
    }

    public LatestPolandData getLatestPolandData() {
        return webClient.get().uri(makeLatestUri(Constants.POLAND)).retrieve().bodyToMono(LatestPolandData.class).block();
    }

    public LatestLithuania getLatestLithuaniaData() {
        return webClient.get().uri(makeLatestUri(Constants.LITHUANIA)).retrieve().bodyToMono(LatestLithuania.class).block();
    }

    private String makeLatestUri(String country) {
        return KEY_VALUE_STORES + country + LATEST;
    }


}
