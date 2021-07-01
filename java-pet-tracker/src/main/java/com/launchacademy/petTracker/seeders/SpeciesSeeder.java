package com.launchacademy.petTracker.seeders;

import com.launchacademy.petTracker.models.Species;
import com.launchacademy.petTracker.repositories.SpeciesRepository;
import java.util.List;
import javax.xml.catalog.Catalog;
import org.springframework.stereotype.Component;

@Component
public class SpeciesSeeder {
  public void seed(SpeciesRepository speciesRepository) {
    Species dog = new Species();
    dog.setName("Dog");

    Species cat = new Species();
    cat.setName("Cat");

    List<Species> speciesList = (List<Species>) speciesRepository.findAll();
    if (speciesList.size() == 0) {
      speciesRepository.save(dog);
      speciesRepository.save(cat);
    }
  }
}
