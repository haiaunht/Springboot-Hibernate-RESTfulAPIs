package com.launchacademy.teamrosterwithspring.services;

import com.launchacademy.teamrosterwithspring.models.Player;
import com.launchacademy.teamrosterwithspring.models.Team;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TeamService {
  List<Team> getList();
  void addToList(Team team);
  Team get(Integer index);
  List<Player> getPlayersPerPosition(String name) ;
  Set<String> getAllPositions();
}
