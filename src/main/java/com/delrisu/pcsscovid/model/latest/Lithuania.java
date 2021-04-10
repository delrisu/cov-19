package com.delrisu.pcsscovid.model.latest;

import com.delrisu.pcsscovid.model.Country;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lithuania extends Country {

    private Long active;
    private Long infected;
    private Long recovered;
    private Long deceased;
    private Long newCases;
}
