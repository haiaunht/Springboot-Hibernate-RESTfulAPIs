package com.launchacademy.monkeycrewlist.controllers;

import com.launchacademy.monkeycrewlist.models.CrewMember;
import com.launchacademy.monkeycrewlist.repositories.CrewMemberRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crewmembers")
public class CrewMembersController {

  CrewMemberRepository repository;

  @Autowired
  public CrewMembersController(
      CrewMemberRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public String getCrewMembers(Model model) {
    model.addAttribute("crewmembers", repository.findAll());
    return "crewmembers/index";
  }

  @GetMapping("/new")
  public String newParty(@ModelAttribute CrewMember crewMember) {
    return "crewmembers/new";
  }

  @PostMapping
  public String addParty(@ModelAttribute @Valid CrewMember crewMember, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      return "crewmembers/new";
    }
    else {
      this.repository.save(crewMember);
      return "redirect:/crewmembers" ;
    }
  }
}
