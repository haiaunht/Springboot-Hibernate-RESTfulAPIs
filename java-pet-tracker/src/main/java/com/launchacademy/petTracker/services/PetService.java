package com.launchacademy.petTracker.services;

import com.launchacademy.petTracker.dtos.PetDto;
import com.launchacademy.petTracker.mappers.PetMapper;
import com.launchacademy.petTracker.models.Pet;
import com.launchacademy.petTracker.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PetService {
  private final PetRepository petRepository;
  private final PetMapper petMapper;

  @Autowired
  public PetService(PetRepository petRepository,
      PetMapper petMapper) {
    this.petRepository = petRepository;
    this.petMapper = petMapper;
  }

  public Page<PetDto> findAll(Pageable pageable) {
    Page<Pet> page = petRepository.findAll(pageable);
    return new PageImpl<PetDto>(petMapper.petsToPetDtos(page.getContent()), pageable, page.getTotalElements());
  }
}
