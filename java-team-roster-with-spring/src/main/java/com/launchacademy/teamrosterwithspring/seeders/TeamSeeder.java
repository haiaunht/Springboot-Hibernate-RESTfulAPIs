package com.launchacademy.teamrosterwithspring.seeders;

import com.launchacademy.teamrosterwithspring.models.Team;
import com.launchacademy.teamrosterwithspring.repositories.TeamRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TeamSeeder implements CommandLineRunner {
  private TeamRepository teamRepository;

  @Autowired
  public TeamSeeder(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    List<String> teamNamesList = Arrays.asList("Norway", "South Korea", "Sweden",
        "Switzerland", "United States");

    for(String teamName : teamNamesList) {
      List<Team> teams = teamRepository.findAllByName(teamName);
      if(teams.isEmpty()){
        Team team = new Team();
        team.setName(teamName);
        teamRepository.save(team);
      }
    }
  }
}
