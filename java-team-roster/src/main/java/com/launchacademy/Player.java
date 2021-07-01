package com.launchacademy;

public class Player {
  private String name;
  private String position;

  public Player(String position, String name) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return this.position;
  }

  public void setPosition(String position) {
    this.position = position;
  }
}
