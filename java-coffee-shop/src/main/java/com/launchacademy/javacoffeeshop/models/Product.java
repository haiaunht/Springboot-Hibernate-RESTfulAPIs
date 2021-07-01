package com.launchacademy.javacoffeeshop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
  private Integer id;
  private String name;
  private String description;
  private Double price;
  private Integer caffeineRating;
}
