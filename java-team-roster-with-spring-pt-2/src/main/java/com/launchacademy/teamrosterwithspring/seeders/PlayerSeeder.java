package com.launchacademy.teamrosterwithspring.seeders;

import com.launchacademy.teamrosterwithspring.models.Player;
import com.launchacademy.teamrosterwithspring.models.Team;
import com.launchacademy.teamrosterwithspring.repositories.PlayerRepository;
import com.launchacademy.teamrosterwithspring.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PlayerSeeder implements CommandLineRunner {
  private PlayerRepository playerRepository;
  private TeamRepository teamRepository;

  @Autowired
  public PlayerSeeder(
      PlayerRepository playerRepository, TeamRepository teamRepository) {
    this.playerRepository = playerRepository;
    this.teamRepository = teamRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Team norway = teamRepository.findByName("Norway");
    if (norway != null && norway.getPlayers().size() == 0) {
      Player player = new Player();
      player.setTeam(norway);
      player.setPosition("Skip");
      player.setName("Thomas Ulsrud");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(norway);
      player.setPosition("Third");
      player.setName("Torger Nergård");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(norway);
      player.setPosition("Second");
      player.setName("Christoffer Svae");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(norway);
      player.setPosition("Lead");
      player.setName("Håvard Vad Petersson");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(norway);
      player.setPosition("Alternate");
      player.setName("Markus Høiberg");
      playerRepository.save(player);
    }

    Team korea = teamRepository.findByName("South Korea");
    if (korea != null && korea.getPlayers().size() == 0) {
      Player player = new Player();
      player.setTeam(korea);
      player.setPosition("Skip");
      player.setName("Kim Chang-min");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(korea);
      player.setPosition("Third");
      player.setName("Seong Se-hyeon");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(korea);
      player.setPosition("Second");
      player.setName("Oh Eun-su");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(korea);
      player.setPosition("Lead");
      player.setName("Lee Ki-bok");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(korea);
      player.setPosition("Alternate");
      player.setName("Kim Min-chan");
      playerRepository.save(player);
    }

    Team sweden = teamRepository.findByName("Sweden");
    if (sweden != null && sweden.getPlayers().size() == 0) {
      Player player = new Player();
      player.setTeam(sweden);
      player.setPosition("Skip");
      player.setName("Niklas Edin");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(sweden);
      player.setPosition("Third");
      player.setName("Oskar Eriksson");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(sweden);
      player.setPosition("Second");
      player.setName("Rasmus Wranå");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(sweden);
      player.setPosition("Lead");
      player.setName("Christoffer Sundgren");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(sweden);
      player.setPosition("Alternate");
      player.setName("Henrik Leek");
      playerRepository.save(player);
    }

    Team switzerland = teamRepository.findByName("Switzerland");
    if (switzerland != null && switzerland.getPlayers().size() == 0) {
      Player player = new Player();
      player.setTeam(switzerland);
      player.setPosition("Fourth");
      player.setName("Benoît Schwarz");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(switzerland);
      player.setPosition("Third");
      player.setName("Claudio Pätz");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(switzerland);
      player.setPosition("Skip");
      player.setName("Peter de Cruz");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(switzerland);
      player.setPosition("Lead");
      player.setName("Valentin Tanner");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(switzerland);
      player.setPosition("Alternate");
      player.setName("Dominik Märki");
      playerRepository.save(player);
    }

    Team usa = teamRepository.findByName("United States");
    if (usa != null && usa.getPlayers().size() == 0) {
      Player player = new Player();
      player.setTeam(usa);
      player.setPosition("Skip");
      player.setName("John Shuster");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(usa);
      player.setPosition("Third");
      player.setName("Tyler George");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(usa);
      player.setPosition("Second");
      player.setName("Matt Hamilton");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(usa);
      player.setPosition("Lead");
      player.setName("John Landsteiner");
      playerRepository.save(player);

      player = new Player();
      player.setTeam(usa);
      player.setPosition("Alternate");
      player.setName("Joe Polo");
      playerRepository.save(player);
    }
  }
}
