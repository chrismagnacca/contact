package com.cgs.contact.components;

import com.cgs.contact.models.Neighborhood;
import com.cgs.contact.repositories.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class NeighborhoodCache {
    public static List<Neighborhood> neighborhoods;

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @PostConstruct
    public void LoadNeighborhoodGeometry() {
        this.neighborhoods = this.neighborhoodRepository.findAll();
    }
}
