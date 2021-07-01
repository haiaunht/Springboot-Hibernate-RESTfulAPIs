package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.FriendRepository;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PartyService {
  private PartyRepository partyRepo;
  private FriendRepository friendRepository;

  @Autowired
  public PartyService(PartyRepository partyRepository, FriendRepository friendRepository) {
    this.partyRepo = partyRepository;
    this.friendRepository = friendRepository;
  }

  public Party findById(Integer id) {
    return this.partyRepo.findById(id).get();
  }

  public void add(Party party) {
    this.partyRepo.save(party);
  }

  public List<Party> findAll() {
    return (List<Party>) this.partyRepo.findAll();
  }

  public Optional<Party> findPartyByName(Integer id) {
    return this.partyRepo.findById(id);
  }

  public void delete(Integer id) {
    List<Friend> friendsToRemoveFromParty = this.partyRepo.findById(id).get().getFriends();
    for (Friend friend : friendsToRemoveFromParty) {
      friend.setParty(null);
      friendRepository.save(friend);
    }
    this.partyRepo.delete(id);
  }

  public int partyIdWithFriend(Integer id) {
    Optional<Friend> friend = friendRepository.findById(id);
    return friend.get().getParty().getId();
  }
}
