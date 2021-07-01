package com.launchacademy.petTracker.seeders;

import com.launchacademy.petTracker.repositories.PetRepository;
import com.launchacademy.petTracker.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  @Autowired private PetRepository petRepository;
  @Autowired private PetSeeder petSeeder;
  @Autowired private SpeciesRepository speciesRepository;
  @Autowired private SpeciesSeeder speciesSeeder;


  @Override
  public void run(String... args) throws Exception {
    speciesSeeder.seed(speciesRepository);
    petSeeder.seed(petRepository, speciesRepository);
  }
}
