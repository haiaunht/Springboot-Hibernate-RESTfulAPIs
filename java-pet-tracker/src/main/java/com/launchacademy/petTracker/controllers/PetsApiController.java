package com.launchacademy.petTracker.controllers;

import com.launchacademy.petTracker.dtos.PetDto;
import com.launchacademy.petTracker.models.Pet;
import com.launchacademy.petTracker.repositories.PetRepository;
import com.launchacademy.petTracker.services.PetService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pets")
public class PetsApiController {

  @Autowired private PetRepository petRepository;
  @Autowired private PetService petService;

  @GetMapping
//  public Iterable<Pet> displayAllPets(Pageable pageable) {
//    return petRepository.findAll(pageable);
//  }
  public Page<PetDto> displayAllPets(Pageable pageable) {
    return petService.findAll(pageable);
  }

  @PostMapping
  public Pet create(@RequestBody Pet pet) {
    return petRepository.save(pet);
  }

  //curl -X POST localhost:8080/api/v1/pets -H 'Content-type:application/json' -d '{"name":"Kitty", "species": {"id":2, "name":"Cat"}, "breed": "ragdoll", "age":1, "neutered":false}'
}
