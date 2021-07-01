package com.launchacademy.launchrpg.seeders;

import com.google.inject.internal.util.Lists;
import com.launchacademy.launchrpg.models.Archetype;
import com.launchacademy.launchrpg.models.PlayerCharacter;
import com.launchacademy.launchrpg.models.School;
import com.launchacademy.launchrpg.models.Spell;
import com.launchacademy.launchrpg.repositories.ArchetypeRepository;
import com.launchacademy.launchrpg.repositories.PlayerCharacterRepository;
import com.launchacademy.launchrpg.repositories.SchoolRepository;
import com.launchacademy.launchrpg.repositories.SpellRepository;
import org.hibernate.loader.custom.ScalarResultColumnProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoSeeder implements CommandLineRunner {

  private PlayerCharacterRepository playerCharacterRepository;
  private ArchetypeRepository archetypeRepository;
  private SchoolRepository schoolRepository;
  private SpellRepository spellRepository;

  @Autowired
  public DemoSeeder(
      PlayerCharacterRepository playerCharacterRepository,
      ArchetypeRepository archetypeRepository,
      SchoolRepository schoolRepository,
      SpellRepository spellRepository) {
    this.playerCharacterRepository = playerCharacterRepository;
    this.archetypeRepository = archetypeRepository;
    this.schoolRepository = schoolRepository;
    this.spellRepository = spellRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Archetype archetype = new Archetype();
    PlayerCharacter playerCharacter = new PlayerCharacter();

    if (Lists.newArrayList(archetypeRepository.findAll()).size() == 0) {
      archetype.setType("Rogue");
      archetype.setHitDice(8);
      archetype.setPrimaryStat("Dex");
      archetypeRepository.save(archetype);
    }

    if (Lists.newArrayList(playerCharacterRepository.findAll()).size() == 0) {
      playerCharacter.setArchetype(archetype);
      playerCharacter.setName("Regis");
      playerCharacter.setRace("Halfling");
      playerCharacter.setBackground("Icewind Dale's Halfling Rogue Extraordinarre");
      playerCharacter.setLevel(1);
      playerCharacterRepository.save(playerCharacter);
    }

    School school = new School();
    Spell spell = new Spell();

    if (Lists.newArrayList(schoolRepository.findAll()).size() == 0) {
      school.setName("Enchantment Description");
      school.setDescription("Giving objects special powers, and influencing people");
      schoolRepository.save(school);
    }

    if (Lists.newArrayList(spellRepository.findAll()).size() == 0) {
      spell.setSchool(school);
      spell.setName("Charm Description");
      spell.setDescription("Good for making Friends School");
      spell.setLevel(2);
      spellRepository.save(spell);
    }

  }
}