package com.example.challenge.javaspringdiceroller.controllers;

import com.example.challenge.javaspringdiceroller.models.DiceRoll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollsController {
  @GetMapping("/rolls/new")
  public String getNew(@RequestParam(required = false) Integer guess,
                        @RequestParam(required = false) Integer diceCount,
                        Model model) {
    DiceRoll diceRoll = new DiceRoll();
    int num = 0;
    int count = 0;

    if (diceCount == null) {
     num = diceRoll.getRandomNumber();
    } else {
      while (count < diceCount) {
        num += diceRoll.getRandomNumber();
        count++;
      }
    }

    if (guess != null) {
      if (num == guess) {
        model.addAttribute("result", "YOU GUESSED THE NUMBER");
      } else if (guess < num) {
        model.addAttribute("result", "Nope. Sorry. Try again");
      } else {
        model.addAttribute("result", "Close. If we were playing price is right rules, you would have won.");
      }
    }

    model.addAttribute("num", num);

    //render src/main/webapp/rolls/show.jsp
    return "show";
  }

  @GetMapping("/batchRolls/new")
  public String getBatchRollNew(@RequestParam(required = false) Integer guess,
      @RequestParam(required = false) Integer diceCount,
      @RequestParam(required = false) Integer rollCount, Model model) {

    List<DiceRoll> list = new ArrayList<>();
    Map<DiceRoll, List<Integer>> dicesPerRoll = new HashMap<>();

    String result = "You rolled: ";
    int rolls = 0;
    int eachNum = 0;
    while (rolls < rollCount) {
      List<Integer> dices = new ArrayList<>();
      DiceRoll each = new DiceRoll();
      int num = 0, count = 0;

      if (diceCount == null) {
        num = each.getRandomNumber();
      } else {
        while (count < diceCount) {
          eachNum = each.getRandomNumber();
          num += eachNum;
          count++;
          result += eachNum + " ";
          dices.add(eachNum);
        }
        dicesPerRoll.put(each, dices);
      }
      System.out.println(num);

      if (guess != null) {
        if (num == guess) {
          result += ". YOU GUESSED THE NUMBER";
        } else if (guess < num) {
          result += ". Nope. Sorry. Try again";
        } else {
          result += ". Close. If we were playing price is right rules, you would have won.";
        }
      }
      each.setResult(result);
      result = "You rolled: ";
      num = 0;
      list.add(each);
      rolls++;
    }
    model.addAttribute("map", dicesPerRoll);
    model.addAttribute("list", list);
    
    return "show";
  }

}
