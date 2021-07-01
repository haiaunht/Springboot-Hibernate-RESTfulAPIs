package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.services.PartyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parties")
public class PartyAPIV1Controller {

  private PartyService partyService;

  @Autowired
  public PartyAPIV1Controller(PartyService partyService) {
    this.partyService = partyService;
  }

  @GetMapping
  public List<Party> getFriendList() {
    return partyService.findAll();
  }

}
