package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.repositories.FriendRepository;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  @Autowired private PartyRepository partyRepository;
  @Autowired private PartySeeder partySeeder;
  @Autowired private FriendRepository friendRepository;
  @Autowired private FriendSeeder friendSeeder;

  @Override
  public void run(String... args) throws Exception {
    partySeeder.seed(partyRepository);
    friendSeeder.seed(friendRepository, partyRepository);
  }
}
