package com.launchacademy.javastarships.controllers;

import com.launchacademy.javastarships.models.StarShip;
import com.launchacademy.javastarships.services.StarShipService;
import java.util.List;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/starships")
public class StarShipsController {
  private StarShipService starShipService;

  @Autowired
  public StarShipsController(StarShipService starShipService) {
    this.starShipService = starShipService;
  }

  @GetMapping
  public String getStarShipsList(Model model) {
    model.addAttribute("ships", starShipService.findAll());
    return "starShips/index";
  }

  @GetMapping("/{starShipId}")
  public String getStarShipById(@PathVariable Integer starShipId, Model model) {
    if (starShipId > starShipService.findAll().size() || starShipId <0) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } else {
      StarShip shipWithId = starShipService.get(starShipId); //id - 1 already taken care in Session
      model.addAttribute("ship", shipWithId);
      return "starShips/show";
    }
  }

  @GetMapping("/new")
  public String addNewStarShip(@ModelAttribute StarShip starShip) { //, Model model) {
    //model.addAttribute("starShip", starShip);
    return "starShips/new";
  }

  @PostMapping
  public String createNewStarShip(@ModelAttribute StarShip starShip) {
    int id = starShipService.findAll().size() + 1;
    starShip.setId(id);
    starShipService.addToList(starShip);
    return "redirect:/starships/" + starShip.getId();
  }
}
