package com.launchacademy.teamrosterwithspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {
  @Id
  @SequenceGenerator(name = "player_generator",sequenceName = "players_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "position", nullable = false)
  private String position;

  @Column(name = "team_id", nullable = false, insertable = false , updatable = false)
  private Integer team_id;

  @ManyToOne
  @JoinColumn(name = "team_id", nullable = false)
  private Team team;

  public void setTeam(Team team) {
    this.team = team;
  }
}

