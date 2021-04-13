package com.delrisu.pcsscovid.service;

import com.delrisu.pcsscovid.model.restCountries.RestCountry;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Service
public class RestCountriesService {

    private final WebClient webClient;

    public RestCountriesService() {
        this.webClient = WebClient.builder().baseUrl("https://restcountries.eu/rest/v2/name/").build();
    }

    public Long getPopulation(String country) {
        return Objects.requireNonNull(webClient.get().uri(country).retrieve().bodyToMono(RestCountry[].class).block())[0].getPopulation();
    }
}
