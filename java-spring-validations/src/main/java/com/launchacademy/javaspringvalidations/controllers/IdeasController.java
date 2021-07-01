package com.launchacademy.javaspringvalidations.controllers;

import com.launchacademy.javaspringvalidations.models.Idea;
import com.launchacademy.javaspringvalidations.repositories.IdeaRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ideas")
public class IdeasController {
  private IdeaRepository ideaRepository;

  @Autowired
  public IdeasController(IdeaRepository ideaRepository) {
    this.ideaRepository = ideaRepository;
  }

  @GetMapping("/new")
  public String getNew(Model model) {
    Idea idea = new Idea();
    model.addAttribute("idea", idea);
    return "ideas/new";
  }

  @PostMapping("/api/v1/ideas")
  public ResponseEntity create(@Valid @RequestBody Idea idea, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    }
    else {
      return new ResponseEntity<Idea>(ideaRepository.save(idea), HttpStatus.CREATED);
    }
  }

  @PostMapping
  public String create(@ModelAttribute @Valid Idea idea, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      return "ideas/new";
    }
    else {
      ideaRepository.save(idea);
      return "redirect:/ideas/new";
    }
  }
}
