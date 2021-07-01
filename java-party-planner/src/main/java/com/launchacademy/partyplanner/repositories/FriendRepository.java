package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Friend;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Integer> {

  @Query("SELECT f FROM Friend f ORDER BY f.firstName")
  public List<Friend> findAllByFirstnameDesc();

  @Modifying
  @Transactional
  @Query("update Friend f set party_id = :newPartyId where id = :friendId")
  public void updateFriend(@Param("newPartyId") Integer newPartyId, @Param("friendId") Integer friendId);

  //may do method update setParty to null
}
