package com.delrisu.pcsscovid.model.restCountries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestCountry {
    private String name;
    private Long population;
}
