package com.example.challenge.javaspringdiceroller.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class DiceRoll {
  private int randomNumber;
  private String result = "";
  private List<Integer> listDicesNum ;

  public DiceRoll() {
    listDicesNum = new ArrayList<>();
  }

  public int getRandomNumber() {
    return (int)Math.floor(Math.random() * 6 + 1);
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getResult() {
    return this.result;
  }

  public void setDicesNum(List<Integer> list) {
    listDicesNum = list;
  }

  public List<Integer> getListDicesNum() {
    return this.listDicesNum;
  }
}
