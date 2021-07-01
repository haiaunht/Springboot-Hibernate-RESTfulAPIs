package com.launchacademy.petTracker.repositories;

import com.launchacademy.petTracker.models.Species;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends CrudRepository<Species, Integer> {
  @Query("SELECT s FROM Species s WHERE s.name = :name")
  public Species findByName(@Param("name") String name);
}
