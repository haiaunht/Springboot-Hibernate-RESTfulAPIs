package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.services.FriendService;
import com.launchacademy.partyplanner.services.PartyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/friends")
public class FriendApiV1Controller {
  private FriendService friendService;

  @Autowired
  public FriendApiV1Controller(FriendService friendService) {
    this.friendService = friendService;
  }

  @GetMapping
  public List<Friend> getFriendList() {
    return friendService.findAll();
  }
}
