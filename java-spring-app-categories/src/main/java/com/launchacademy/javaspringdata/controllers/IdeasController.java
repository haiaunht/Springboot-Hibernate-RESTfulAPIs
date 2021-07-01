package com.launchacademy.javaspringdata.controllers;

import com.launchacademy.javaspringdata.models.Idea;
import com.launchacademy.javaspringdata.repositories.IdeaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdeasController {
  private IdeaRepository ideaRepository;

  @Autowired
  public IdeasController(IdeaRepository ideaRepository) {
    this.ideaRepository = ideaRepository;
  }

  @GetMapping("/api/v1/ideas")
  public Iterable<Idea> getIdeas() {
    return ideaRepository.findAll();
  }

  @GetMapping("/api/v1/ideas/{id}")
  public Optional<Idea> getIdeaById(@PathVariable Integer id) {
    return ideaRepository.findById(id);
  }

  @GetMapping("/api/v1/ideas/name/{name}")
  public Idea getIdeasByName(@PathVariable String name) {
    return ideaRepository.findByName(name);
  }

  @GetMapping("/api/v1/ideas/name-start-with/{start}")
  public Iterable<Idea> getIdeasByNameStaringWith(@PathVariable String start) {
    return ideaRepository.findByNameStartingWith(start);
  }

  @GetMapping("/api/v1/ideas/name-end-with/{end}")
  public Iterable<Idea> getIdeasByNameEndingWith(@PathVariable String end) {
    return ideaRepository.findByNameEndingWith(end);
  }

  @GetMapping("/api/v1/ideas/description-not-contain/{word}")
  public Iterable<Idea> getIdeasByDescriptionNotContain(@PathVariable String word) {
    return ideaRepository.findByDescriptionNotContaining(word);
  }
}
