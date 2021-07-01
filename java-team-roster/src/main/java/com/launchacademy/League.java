package com.launchacademy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class League {
  private List<Team> teams;
  public League() {
    this.teams = new ArrayList<Team>();
  }

  public void addTeam(Team team) {
    teams.add(team);
  }

  static League getLeague() {
    League theLeague = new League();

    Team team = new Team("Norway");
    team.addPlayer(new Player("Skip", "Thomas Ulsrud"));
    team.addPlayer(new Player("Third", "Torger Nergård"));
    team.addPlayer(new Player("Second", "Christoffer Svae"));
    team.addPlayer(new Player("Lead", "Håvard Vad Petersson"));
    team.addPlayer(new Player("Alternate", "Markus Høiberg"));
    theLeague.addTeam(team);

    team = new Team("South Korea");
    team.addPlayer(new Player("Skip", "Kim Chang-min"));
    team.addPlayer(new Player("Third", "Seong Se-hyeon"));
    team.addPlayer(new Player("Second", "Oh Eun-su"));
    team.addPlayer(new Player("Lead", "Lee Ki-bok"));
    team.addPlayer(new Player("Alternate", "Kim Min-chan"));
    theLeague.addTeam(team);

    team = new Team("Sweden");
    team.addPlayer(new Player("Skip", "Niklas Edin"));
    team.addPlayer(new Player("Third", "Oskar Eriksson"));
    team.addPlayer(new Player("Second", "Rasmus Wranå"));
    team.addPlayer(new Player("Lead", "Christoffer Sundgren"));
    team.addPlayer(new Player("Alternate", "Henrik Leek"));
    theLeague.addTeam(team);

    team = new Team("Switzerland");
    team.addPlayer(new Player("Fourth", "Benoît Schwarz"));
    team.addPlayer(new Player("Third", "Claudio Pätz"));
    team.addPlayer(new Player("Skip", "Peter de Cruz"));
    team.addPlayer(new Player("Lead", "Valentin Tanner"));
    team.addPlayer(new Player("Alternate", "Dominik Märki"));
    theLeague.addTeam(team);

    team = new Team("United States");
    team.addPlayer(new Player("Skip", "John Shuster"));
    team.addPlayer(new Player("Third", "Tyler George"));
    team.addPlayer(new Player("Second", "Matt Hamilton"));
    team.addPlayer(new Player("Lead", "John Landsteiner"));
    team.addPlayer(new Player("Alternate", "Joe Polo"));
    theLeague.addTeam(team);
    return theLeague;
  }

  public List<Team> getTeams() {
    return this.teams;
  }

  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

  public Map<String, List<Player>> getPlayersPerPosition() {
    Map<String, List<Player>> result = new HashMap<>();
    for (Team team : this.teams) {
      List<Player> players = team.getPlayers();
      for (Player player : players) {
        if (!result.containsKey(player.getPosition())) {
          String key = player.getPosition();
          List<Player> value = new ArrayList<>();
          value.add(player);
          result.put(key, value);
        } else {
          List<Player> value = result.get(player.getPosition());
          value.add(player);
        }
      }
    }
    return result;
  }

  public Map<Player, String> getPlayersPerTeam() {
    Map<Player, String> result = new HashMap<>();
    for (Team team : this.teams) {
      List<Player> players = team.getPlayers();
      for (Player player : players) {
        if (!result.containsKey(player)) {
          result.put(player, team.getTeamName());
        }
      }
    }
    return result;
  }
}
