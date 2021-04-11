package com.delrisu.pcsscovid.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryData {
    private String country;
    private Long newCases;
    private Long allCases;
    private Long population;
    private double newCasesPercent;
    private double allCasesPercent;

    public void setAdvancedStatistics(Long population) {
        this.population = population;
        if (this.allCases != null && this.newCases != null) {
            this.newCasesPercent = (newCases * 1.0) / population * 100.0;
            this.allCasesPercent = (allCases * 1.0) / population * 100.0;
        }
    }
}
