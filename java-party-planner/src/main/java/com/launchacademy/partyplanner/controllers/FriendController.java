package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.services.FriendService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/friends")
public class FriendController {
  private FriendService friendService;

  @Autowired
  public FriendController(FriendService friendService) {
    this.friendService = friendService;
  }

  @GetMapping
  public String getFriendList(Model model){
    model.addAttribute("friends", friendService.findAllByFirstnameDesc());
    return "friends/index";
  }

  @GetMapping("/new")
  public String newParty(@ModelAttribute("friend") Friend friend) {
    return "friends/new";
  }

  @PostMapping
  public String addParty(@ModelAttribute("friend") @Valid Friend friend,
      BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "friends/new";
    }
    else {
      friendService.add(friend);
      return "redirect:/friends";
    }
  }

  //the id is the existing party.id, when choosing a friend, update a friend.party_id to party.id
  @PostMapping("/update/{id}")
  public String updatePartyGuests(@PathVariable Integer id, @ModelAttribute Friend incomingFriend) {
    friendService.updatePartyForChosenFriend(id, incomingFriend.getId());
    return "redirect:/parties/show/" + id;
  }

//  //remove party_id when the invite is remove
//  @PostMapping("/remove/{id}")
//  public String removeTheInviteFromParty(@PathVariable Integer id, @ModelAttribute Friend friend) {
//    System.out.println(friend);
//    int directId = friendService.updateRemoveInvite(id);
//    System.out.println(directId);
//    return "redirect:/parties/show/" + directId;
//  }

//  @GetMapping("/remove/{id}")
//  public String removeTheInviteFromParty(@PathVariable Integer id) {
//    if (id != null) {
//      int partyId = friendService.updateRemoveInvite(id);
//      return "redirect:/parties/show/" + partyId;
//    } else {
//      return "redirect:/friends";
//    }
//  }

}
