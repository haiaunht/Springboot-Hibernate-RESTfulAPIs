package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.repositories.FriendRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
  private FriendRepository friendRepository;

  @Autowired
  public FriendService(FriendRepository friendRepository) {
    this.friendRepository = friendRepository;
  }

  public List<Friend> findAll() {
    return (List<Friend>) friendRepository.findAll();
  }

  public void add(Friend friend) {
    friendRepository.save(friend);
  }

  public List<Friend> findAllByFirstnameDesc() {
    return friendRepository.findAllByFirstnameDesc();
  }

  public void updatePartyForChosenFriend(Integer newPartyId, Integer friendId) {
    this.friendRepository.updateFriend(newPartyId, friendId);
  }

  public void updateRemoveInvite(Integer id) {
    Optional<Friend> friend = friendRepository.findById(id);
    friend.get().setParty(null);
    friendRepository.save(friend.get());
  }
}
