package com.delrisu.pcsscovid.api;

import com.delrisu.pcsscovid.model.LatestPolandData;
import com.delrisu.pcsscovid.service.ApifyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1/")
public class CovidController {

    @Resource(name = "apifyService")
    private ApifyService apifyService;

    @GetMapping("/poland")
    public LatestPolandData getLatestPolandData(){
        return apifyService.getLatestPolandData();
    }
}
