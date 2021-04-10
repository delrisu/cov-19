package com.delrisu.pcsscovid.model;

import com.delrisu.pcsscovid.model.latest.Lithuania;
import com.delrisu.pcsscovid.model.latest.Palestine;
import com.delrisu.pcsscovid.model.latest.Poland;
import com.delrisu.pcsscovid.model.latest.Slovenia;
import com.delrisu.pcsscovid.utils.Constants;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomCountryData {

    public CustomCountryData(Poland poland){
        this.country = Constants.POLAND;
        this.newCases = poland.getDailyInfected();
        this.allCases = poland.getActiveCase();
    }

    public CustomCountryData(Lithuania lithuania){
        this.country = Constants.LITHUANIA;
        this.newCases = lithuania.getNewCases();
        this.allCases = lithuania.getInfected();
    }

    public CustomCountryData(Slovenia slovenia){
        this.country = Constants.SLOVENIA;
        this.newCases = slovenia.getDailyInfected();
        this.allCases = slovenia.getInfectedCases();
    }

    public CustomCountryData(Palestine palestine){
        this.country = Constants.PALESTINE;
        this.newCases = palestine.getNewCases();
        this.allCases = palestine.getInfected();
    }

    private String country;
    private Long newCases;
    private Long allCases;
}
