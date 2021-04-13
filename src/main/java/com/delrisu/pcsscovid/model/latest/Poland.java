package com.delrisu.pcsscovid.model.latest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Poland extends Country {

    private Long infected;
    private Long deceased;
    private Long recovered;
    private Long activeCase;
    private Long dailyInfected;
    private Long dailyTested;
    private Long dailyPositiveTests;
    private Long dailyDeceased;
    private Long dailyDeceasedDueToCovid;
    private Long dailyRecovered;
    private Long dailyQuarantine;

}
