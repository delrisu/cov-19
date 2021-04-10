package com.delrisu.pcsscovid.api;

import com.delrisu.pcsscovid.model.CustomCountryData;
import com.delrisu.pcsscovid.model.Country;
import com.delrisu.pcsscovid.model.latest.Lithuania;
import com.delrisu.pcsscovid.model.latest.Palestine;
import com.delrisu.pcsscovid.model.latest.Poland;
import com.delrisu.pcsscovid.model.latest.Slovenia;
import com.delrisu.pcsscovid.service.ApifyService;
import com.delrisu.pcsscovid.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1")
public class InfoController {

    @Resource(name = "apifyService")
    private ApifyService apifyService;

    @GetMapping("/full")
    public Country getLatestData(@RequestParam String country){
        return apifyService.getLatestData(country);
    }

    @GetMapping
    public CustomCountryData getData(@RequestParam String country){
        return apifyService.getData(country);
    }
}
