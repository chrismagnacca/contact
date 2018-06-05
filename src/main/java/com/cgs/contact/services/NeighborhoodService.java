package com.cgs.contact.services;

import com.cgs.contact.models.Neighborhood;
import com.cgs.contact.repositories.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NeighborhoodService {
    private NeighborhoodRepository neighborhoodRepository;

    @Autowired
    public NeighborhoodService(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    public List<Neighborhood> AllNeighborhoods() {
        return neighborhoodRepository.findAll();
    }
}
