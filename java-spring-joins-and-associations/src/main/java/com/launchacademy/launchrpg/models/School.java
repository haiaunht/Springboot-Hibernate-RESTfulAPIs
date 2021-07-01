package com.launchacademy.launchrpg.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="schools")
public class School {
  @Id
  @SequenceGenerator(name="school_generator", sequenceName="schools_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="school_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  private String name;
  private String description;

  @OneToMany(mappedBy = "school")
  private List<Spell> spells = new ArrayList<Spell>();
}
