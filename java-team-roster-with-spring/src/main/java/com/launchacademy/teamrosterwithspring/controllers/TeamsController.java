package com.launchacademy.teamrosterwithspring.controllers;

import com.launchacademy.teamrosterwithspring.models.Team;
import com.launchacademy.teamrosterwithspring.repositories.TeamRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TeamsController {
  private TeamRepository teamRepository;

  @Autowired
  public TeamsController(
      TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }


  @GetMapping("/")
  public String listTeams(Model model) {
    model.addAttribute("allTeams", teamRepository.findAll());
    return "teams/index";
  }

  @GetMapping("/teams/{indexInArray}")
  public String getTeamByIndex(@PathVariable Integer indexInArray, Model model) {
    Optional<Team> current = teamRepository.findById(indexInArray);
    if (!current.isPresent()) {
      return "teams/error";
    } else {
      model.addAttribute("current", current.get());
      System.out.println(teamRepository.findById(indexInArray));
      return "teams/show";
    }
  }


  @GetMapping("/fantasy/team/new")
  public String getNewForm(@ModelAttribute Team team) {
    return "teams/new";
  }

  @PostMapping("/fantasy/teams")
  public String createNewTeam(@ModelAttribute Team team) {
    teamRepository.save(team);
    return "redirect:/teams/" + team.getId();
  }

//  @GetMapping("/fantasy/teams")
//  public String getAllFantasyTeam(Model model) {
//    model.addAttribute("allTeams", teamService.getList());
//    return "teams/index";
//  }
//
//  @GetMapping("/positions")
//  public String listAllPositions(Model model) {
//    Set<String> positions = teamService.getAllPositions();
//    model.addAttribute("positions", positions);
//    return "positions/index";
//  }
//
//  @GetMapping("/positions/{positionName}")
//  public String getListOfAllPositions(@PathVariable String positionName, Model model) {
//    model.addAttribute("position", positionName);
//    model.addAttribute("players", teamService.getPlayersPerPosition(positionName));
//    System.out.println(teamService.getPlayersPerPosition(positionName));
//    return "positions/show";
//  }
}
