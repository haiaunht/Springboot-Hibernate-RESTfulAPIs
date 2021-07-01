package com.example.lombokexercise.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class Station {
  @ToString.Exclude private String name;
  private String location;
}
