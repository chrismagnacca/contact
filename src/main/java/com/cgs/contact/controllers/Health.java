package com.cgs.contact.controllers;


import com.cgs.contact.services.NeighborhoodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Health {
    private NeighborhoodService neighborhoodService;

    @RequestMapping("/health")
    public String Index(){
        return "OK";
    }

    public Health(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }
}
