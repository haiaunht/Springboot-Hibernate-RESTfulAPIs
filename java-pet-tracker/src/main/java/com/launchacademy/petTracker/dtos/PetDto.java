package com.launchacademy.petTracker.dtos;

import com.launchacademy.petTracker.models.Pet;
import com.launchacademy.petTracker.models.Species;
import javax.persistence.criteria.CriteriaBuilder.In;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PetDto {
  private Integer id;
  private String name;
  private String breed;
  private Integer age;
  private Boolean neutered;
  private Species species;

  public static PetDto fromPet( Pet pet ) {
    PetDto petDto = new PetDto();
    petDto.setName(pet.getName());
    petDto.setBreed(pet.getBreed());
    petDto.setAge(pet.getAge());
    petDto.setNeutered(pet.getNeutered());
    petDto.setSpecies(pet.getSpecies());
    return petDto;
  }
}
