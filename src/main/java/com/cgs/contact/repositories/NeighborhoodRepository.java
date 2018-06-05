package com.cgs.contact.repositories;

import com.cgs.contact.models.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, UUID> {
    List<Neighborhood> findAll();
}
