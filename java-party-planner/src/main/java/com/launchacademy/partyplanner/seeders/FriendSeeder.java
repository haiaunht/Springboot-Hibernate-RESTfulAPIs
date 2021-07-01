package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.FriendRepository;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FriendSeeder  {
//  private FriendRepository friendRepository;
//  private PartyRepository partyRepository;
//
//  @Autowired
//  public FriendSeeder(FriendRepository friendRepository,
//      PartyRepository partyRepository) {
//    this.friendRepository = friendRepository;
//    this.partyRepository = partyRepository;
//  }

//  @Override
  public void seed (FriendRepository friendRepository, PartyRepository partyRepository) {
    Friend emily = new Friend();
    emily.setFirstName("Emily");
    emily.setLastName("Mucken");

    Friend hollie = new Friend();
    hollie.setFirstName("Hollie");
    hollie.setLastName("Thomas");

    Friend wei = new Friend();
    wei.setFirstName("Wei");
    wei.setLastName("Kuang");

    Friend annie = new Friend();
    annie.setFirstName("Annie");
    annie.setLastName("Pineda");

    Friend lan = new Friend();
    lan.setFirstName("Lan");
    lan.setLastName("Nguyen");

    Friend agata = new Friend();
    agata.setFirstName("Agata");
    agata.setLastName("Kapoor");

    List<Friend> friendList = (List<Friend>) friendRepository.findAll();
    if (friendList.size() == 0) {
      friendRepository.save(emily);
      friendRepository.save(hollie);
      friendRepository.save(wei);
      friendRepository.save(annie);
      friendRepository.save(lan);

      agata.setParty(partyRepository.findByName("Apprenti's party"));
      friendRepository.save(agata);
    }

  }
}
