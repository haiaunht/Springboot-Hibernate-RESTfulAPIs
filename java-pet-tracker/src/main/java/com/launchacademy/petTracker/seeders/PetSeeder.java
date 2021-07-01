package com.launchacademy.petTracker.seeders;

import com.launchacademy.petTracker.models.Pet;
import com.launchacademy.petTracker.repositories.PetRepository;
import com.launchacademy.petTracker.repositories.SpeciesRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PetSeeder {
  public void seed(PetRepository petRepository, SpeciesRepository speciesRepository) {
    Pet rory = new Pet();
    rory.setName("Rory");
    rory.setSpecies(speciesRepository.findByName("Dog"));
    rory.setBreed("Retriever");
    rory.setAge(10);
    rory.setNeutered(true);

    Pet maisy = new Pet();
    maisy.setName("Maisy");
    maisy.setSpecies(speciesRepository.findByName("Cat"));
    maisy.setBreed("Tabby");
    maisy.setAge(3);
    maisy.setNeutered(false);

    List<Pet> petList = (List<Pet>) petRepository.findAll();
    if (petList.size() == 0) {
      petRepository.save(rory);
      petRepository.save(maisy);
    }
  }
}
