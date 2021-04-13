package com.delrisu.pcsscovid.api;

import com.delrisu.pcsscovid.model.latest.Country;
import com.delrisu.pcsscovid.model.CountryData;
import com.delrisu.pcsscovid.service.ApifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class InfoController {

    @Resource(name = "apifyService")
    private ApifyService apifyService;

    @GetMapping("/countries/full/{country}")
    public Country getLatestData(@PathVariable String country) {
        return apifyService.getLatestData(country);
    }

    @GetMapping("/countries/{country}")
    public CountryData getData(@PathVariable String country) {
        return apifyService.getData(country);
    }

    @GetMapping("/countries")
    public List<CountryData> getAllData(@RequestParam(required = false) Optional<String> sortBy, @RequestParam(required = false) Optional<Boolean> reversed) {
        return apifyService.getAllData(sortBy, reversed);
    }
}
