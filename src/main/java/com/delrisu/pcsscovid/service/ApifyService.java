package com.delrisu.pcsscovid.service;

import com.delrisu.pcsscovid.model.Country;
import com.delrisu.pcsscovid.model.CustomCountryData;
import com.delrisu.pcsscovid.model.latest.*;
import com.delrisu.pcsscovid.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

@Service("apifyService")
public class ApifyService {

    private final WebClient webClient;

    private Logger logger = LoggerFactory.getLogger(ApifyService.class);

    private final String LATEST = "/records/LATEST?disableRedirect=true";
    private final String KEY_VALUE_STORES = "/key-value-stores";

    public ApifyService() {
        this.webClient = WebClient.builder().baseUrl("https://api.apify.com/v2").build();
    }

    public Country getLatestData(String country) {
        switch (country) {
            case Constants.SLOVENIA:
                return webClient.get().uri(makeLatestUri(Constants.SLOVENIA_LINK)).retrieve()
                        .bodyToMono(Slovenia.class).block();
            case Constants.POLAND:
                return webClient.get().uri(makeLatestUri(Constants.POLAND_LINK)).retrieve()
                        .bodyToMono(Poland.class).block();
            case Constants.LITHUANIA:
                return webClient.get().uri(makeLatestUri(Constants.LITHUANIA_LINK)).retrieve()
                        .bodyToMono(Lithuania.class).block();
            case Constants.PALESTINE:
                return webClient.get().uri(makeLatestUri(Constants.PALESTINE_LINK)).retrieve()
                        .bodyToMono(Palestine.class).block();
            case Constants.ITALY:
                return webClient.get().uri(makeLatestUri(Constants.ITALY_LINK)).retrieve()
                        .bodyToMono(Italy.class).block();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }

    public CustomCountryData getData(String country) {
        switch (country) {
            case Constants.SLOVENIA:
                return new CustomCountryData((Slovenia) getLatestData(country));
            case Constants.POLAND:
                return new CustomCountryData((Poland) getLatestData(country));
            case Constants.LITHUANIA:
                return new CustomCountryData((Lithuania) getLatestData(country));
            case Constants.PALESTINE:
                return new CustomCountryData((Palestine) getLatestData(country));
            case Constants.ITALY:
                return new CustomCountryData((Italy) getLatestData(country));
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }

    private String makeLatestUri(String country) {
        return KEY_VALUE_STORES + country + LATEST;
    }


}
