package com.launchacademy.partyplanner.seeders;

import com.google.inject.internal.util.Lists;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PartySeeder{
//  private PartyRepository partyRepository;
//
//  @Autowired
//  public PartySeeder(PartyRepository partyRepository) {
//    this.partyRepository = partyRepository;
//  }


  public void seed (PartyRepository partyRepository){
    Party apprenti = new Party();
    apprenti.setPartyName("Apprenti's party");
    apprenti.setDescription("Cohorts meeting");
    apprenti.setLocation("Seattle Center");

    Party meetFavFriend = new Party();
    meetFavFriend.setPartyName("Meet my favorite friend");
    meetFavFriend.setDescription("Time to meet everyone");
    meetFavFriend.setLocation("TNT");

    Party timeForFood = new Party();
    timeForFood.setPartyName("Korean's hotpot");
    timeForFood.setDescription("Meet my favorite friend and eat favorite food");
    timeForFood.setLocation("Edmond");

    List<Party> partyList = (List<Party>) partyRepository.findAll();
    if (partyList.size() == 0) {
      partyRepository.save(apprenti);
      partyRepository.save(meetFavFriend);
      partyRepository.save(timeForFood);
    }
  }
}
