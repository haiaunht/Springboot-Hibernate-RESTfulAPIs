package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.PlayerCharacter;
import org.springframework.data.repository.CrudRepository;

public interface PlayerCharacterRepository extends CrudRepository<PlayerCharacter, Integer> {

}
