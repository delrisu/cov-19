package com.delrisu.pcsscovid.model.latest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Italy extends Country {
    private Long hospitalizedWithSymptoms;
    private Long intensiveTherapy;
    private Long totalHospitalized;
    private Long homeInsulation;
    private Long totalPositive;
    private Long newPositive;
    private Long dischargedHealed;
    private Long deceased;
    private Long totalCases;
    private Long tamponi;
}
