package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.services.FriendService;
import com.launchacademy.partyplanner.services.PartyService;
import javax.annotation.processing.Generated;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parties")
public class PartyController {
  private PartyService partyService;
  private FriendService friendService;

  @Autowired
  public PartyController(PartyService partyService,
      FriendService friendService) {
    this.partyService = partyService;
    this.friendService = friendService;
  }

  @GetMapping
  public String getPartyList(Model model) {
    model.addAttribute("parties", this.partyService.findAll());
    return "parties/index";
  }

  @GetMapping("/show/{id}")
  public String showParty(@PathVariable Integer id, Model model) {
    Friend incomingFriend = new Friend();
    model.addAttribute("party", partyService.findById(id));
    model.addAttribute("allFriends", friendService.findAll());
    model.addAttribute("incomingFriend", incomingFriend);
    return "parties/show";
  }

  @GetMapping("/new")
  public String newParty(@ModelAttribute Party party){
    return "parties/new";
  }

  @PostMapping
  public String addParty(@ModelAttribute @Valid  Party party, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      return "parties/new";
    }
    else {
      this.partyService.add(party);
      return "redirect:/parties/show/" + party.getId();
    }
  }

  @GetMapping("/update/{id}")
  public String editParty(@PathVariable Integer id, Model model ) {
    model.addAttribute("partyToUpdate", partyService.findById(id));
    return "parties/update";
  }

  @PostMapping("/update/{id}")
  public String editPartyWithUserChoice(@PathVariable Integer id, @ModelAttribute @Valid Party partyToUpdate, BindingResult bindingResult ) {
    if (bindingResult.hasErrors()) {
      return "redirect:/parties/update/" + id;
    } else {
      Party edit = partyService.findById(id);
      edit.setPartyName(partyToUpdate.getPartyName());
      edit.setDescription(partyToUpdate.getDescription());
      edit.setLocation(partyToUpdate.getLocation());
      partyService.add(edit);
      return "redirect:/parties/show/" + id;
    }
  }

  @DeleteMapping("/delete/{id}")
  public String deleteProduct(@PathVariable Integer id) {
    partyService.delete(id);
    return "redirect:/parties";
  }

  //remove party_id when the invite is remove
  @PostMapping("/remove/{id}")
  public String removeTheInviteFromParty(@PathVariable Integer id, @ModelAttribute Friend friend) {
    int partyIdRedirect = partyService.partyIdWithFriend(id);
    friendService.updateRemoveInvite(id);
    return "redirect:/parties/show/" + partyIdRedirect;
  }
}
