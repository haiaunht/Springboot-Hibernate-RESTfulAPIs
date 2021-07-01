package com.launchacademy.launchrpg.models;

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

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="spells")
public class Spell {
  @Id
  @SequenceGenerator(name="spell_generator", sequenceName="spells_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="spell_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;
  private String name;
  private int level;
  private String description;

  @Column(name = "school_id", nullable = false, insertable = false, updatable = false)
  private Integer school_id;

  @ManyToOne
  @JoinColumn(name="school_id", nullable = false)
  private School school;

  public void setSchool(School school) {
    this.school = school;
  }
}
