package com.launchacademy;

import com.launchacademy.Player;
import java.util.ArrayList;
import java.util.List;

public class Team {
  private String teamName;
  private List<Player> players;

  public Team(String teamName) {
    this.teamName = teamName;
    this.players = new ArrayList<Player>();
  }

  public void addPlayer(Player player) {
    this.players.add(player);
  }

  public String getTeamName() {
    return this.teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public List<Player> getPlayers() {
    return this.players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }
}
