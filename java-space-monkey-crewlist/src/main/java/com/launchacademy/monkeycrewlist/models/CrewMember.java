package com.launchacademy.monkeycrewlist.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "crew_members")
public class CrewMember {

  @Id
  @SequenceGenerator(name = "crew_member_generator",
      sequenceName = "crew_members_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "crew_member_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotBlank
  @Column(name = "name", nullable = false)
  private String name;

  @NotBlank
  @Column(name = "hobby", nullable = false)
  private String hobby;

  @NotBlank
  @Column(name = "rank", nullable = false)
  private String rank;

  @NotNull
  @Range(min = 1, message = "The Great Captain only wants members with 1 or more tours under their belt! ")
  @Column(name = "tours_aboard")
  private Integer toursAboard;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public Integer getToursAboard() {
    return toursAboard;
  }

  public void setToursAboard(Integer toursAboard) {
    this.toursAboard = toursAboard;
  }
}