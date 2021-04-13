package com.delrisu.pcsscovid.model.latest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Palestine extends Country {

    private Long infected;
    private Long tested;
    private Long recovered;
    private Long deceased;
    private Long active;
    private Long newCases;
    private Long newlyRecovered;
    private Long atHome;
}
