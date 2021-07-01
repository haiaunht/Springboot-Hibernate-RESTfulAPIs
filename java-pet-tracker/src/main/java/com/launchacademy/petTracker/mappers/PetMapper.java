package com.launchacademy.petTracker.mappers;

import com.launchacademy.petTracker.dtos.PetDto;
import com.launchacademy.petTracker.models.Pet;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface PetMapper {

  PetDto petToPetDto(Pet pet);
  List<PetDto> petsToPetDtos(List<Pet> pets);
}
