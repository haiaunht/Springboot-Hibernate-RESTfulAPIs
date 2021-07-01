package com.launchacademy.teamrosterwithspring.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {
  @Id
  @SequenceGenerator(name = "team_generator",sequenceName = "teams_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
  private List<Player> players = new ArrayList<Player>();

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public List<Player> getPlayers() {
    return this.players;
  }
}

