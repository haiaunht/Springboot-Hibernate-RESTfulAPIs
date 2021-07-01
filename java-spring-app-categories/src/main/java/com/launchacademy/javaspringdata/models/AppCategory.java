package com.launchacademy.javaspringdata.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categories")
public class AppCategory {
  @Id
  @SequenceGenerator(name="category_generator", sequenceName="categories_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="category_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotEmpty
  @Column(name="name", nullable=false, unique = true)
  private String name;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
