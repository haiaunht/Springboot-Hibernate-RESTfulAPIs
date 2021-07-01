package com.launchacademy.petTracker.controllers;

import com.launchacademy.petTracker.models.Pet;
import com.launchacademy.petTracker.models.Species;
import com.launchacademy.petTracker.repositories.PetRepository;
import com.launchacademy.petTracker.repositories.SpeciesRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetsController {

  @Autowired
  private PetRepository petRepository;
  @Autowired
  private SpeciesRepository speciesRepository;

  @GetMapping
  public String paginatedListOfPet(Pageable pageable, Model model) {
    model.addAttribute("pets", petRepository.findAll(pageable));
    return "pets/index";
  }

  @GetMapping("/new")
//  public String petForm(@ModelAttribute("pet") Pet pet) {
  public String petForm(@ModelAttribute("pet") Pet pet) {
    return "pets/new";
  }

  @PostMapping
  public String createForm(@ModelAttribute("pet") @Valid Pet pet, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "pets/new";
    } else {
      Species checkSpecies = speciesRepository.findByName(pet.getSpecies().getName());
      if (checkSpecies != null) {
        pet.setSpecies(checkSpecies);
        petRepository.save(pet);
      } else {
        checkSpecies = new Species();
        checkSpecies.setName(pet.getSpecies().getName());
        speciesRepository.save(checkSpecies);
        pet.setSpecies(checkSpecies);
        petRepository.save(pet);
      }
      return "redirect:/pets";
    }
  }

  @GetMapping("/{id}")
  public String petShowPage(@PathVariable Integer id, Model model) {
    Optional<Pet> pet = petRepository.findById(id);
    if (!pet.isPresent()) {
      return "pets/error";
    } else {
      model.addAttribute("pet", pet.get());
      return "pets/show";
    }

  }
}
