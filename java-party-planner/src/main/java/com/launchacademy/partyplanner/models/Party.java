package com.launchacademy.partyplanner.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="parties")
public class Party {
  @Id
  @SequenceGenerator(name="party_generator", sequenceName="parties_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="party_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @Column(name = "party_name")
  private String partyName;

  @NotBlank
  @Column(name="description", nullable = false)
  private String description;

  @NotBlank
  @Column(name="location", nullable = false)
  private String location;

  @OneToMany(mappedBy = "party")
  private List<Friend> friends = new ArrayList<>();
}
