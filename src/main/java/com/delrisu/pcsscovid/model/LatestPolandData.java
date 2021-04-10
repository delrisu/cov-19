package com.delrisu.pcsscovid.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestPolandData {

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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime lastUpdatedAtApify;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime lastUpdatedAtSource;
    private String country;
}
