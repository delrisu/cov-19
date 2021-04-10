package com.delrisu.pcsscovid.model.latest;

import com.delrisu.pcsscovid.model.Country;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slovenia extends Country {

    private Long testedCases;
    private Long infectedCases;
    private Long numberOfDeath;
    private Long dailyTested;
    private Long dailyInfected;
    private Long dailyDeaths;
    private Long dailyDischarged;
    private Long dailyHospitalized;
    private Long dailyIntensiveCare;
}
