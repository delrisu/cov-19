package com.delrisu.pcsscovid.service;

import com.delrisu.pcsscovid.model.Country;
import com.delrisu.pcsscovid.model.CountryData;
import com.delrisu.pcsscovid.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service("apifyService")
public class ApifyService {

    private final WebClient webClient;

    @Resource(name = "restCountriesService")
    private RestCountriesService restCountriesService;

    private Logger logger = LoggerFactory.getLogger(ApifyService.class);

    private final String LATEST = "/records/LATEST?disableRedirect=true";
    private final String KEY_VALUE_STORES = "/key-value-stores";

    public ApifyService() {
        this.webClient = WebClient.builder().baseUrl("https://api.apify.com/v2").build();
    }

    public Country getLatestData(String country) {
        if (isHandledCountry(country)) {
            return (Country) webClient.get().uri(makeLatestUri(Utils.getCountryLink(country)))
                    .retrieve().bodyToMono(Utils.getCountryClass(country)).block();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
    }

    private boolean isHandledCountry(String country) {
        return Arrays.asList(Utils.Constants.COUNTRIES).contains(country);
    }

    public CountryData getData(String country) {

        //TODO DB integration (less calls to apify)? DB fill as scheduled task? Redis caching?
        CountryData countryData = Utils.getCountryData(country, getLatestData(country));
        countryData.setAdvancedStatistics(restCountriesService.getPopulation(country));
        return countryData;
    }

    public List<CountryData> getAllData(Optional<String> sortBy, Optional<Boolean> reversed) {

        List<CountryData> countryData = Arrays.stream(Utils.Constants.COUNTRIES).map(this::getData)
                .collect(Collectors.toList());

        final String ALL_CASES = "all_cases";
        final String NEW_CASES = "new_cases";

        if (sortBy.isPresent()) {

            switch (sortBy.get()) {
                case ALL_CASES:
                    countryData = getCollect(countryData, Comparator.comparing(CountryData::getAllCases));
                case NEW_CASES:
                    countryData = getCollect(countryData, Comparator.comparing(CountryData::getNewCases));
                default:
                    countryData = getCollect(countryData, Comparator.comparing(CountryData::getCountry));
            }
        } else {
            countryData = getCollect(countryData, Comparator.comparing(CountryData::getCountry));
        }

        if (reversed.orElse(false)) {
            Collections.reverse(countryData);
        }
        return countryData;
    }

    private List<CountryData> getCollect(List<CountryData> countryData, Comparator<CountryData> compareBy) {
        return countryData.stream().sorted(compareBy).collect(Collectors.toList());
    }

    private String makeLatestUri(String country) {
        return KEY_VALUE_STORES + country + LATEST;
    }


}
