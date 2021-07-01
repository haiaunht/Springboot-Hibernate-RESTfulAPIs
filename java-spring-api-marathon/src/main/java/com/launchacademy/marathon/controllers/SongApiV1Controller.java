package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.repositories.SongRepository;
import java.util.List;
import javax.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/songs")
public class SongApiV1Controller {
  private SongRepository songRepository;

  @Autowired
  public SongApiV1Controller(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  @GetMapping
  public Page<Song> getList(Pageable pageable) {
    return songRepository.findAll(pageable);
  }

  @NoArgsConstructor
  private class UrlNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class UrlNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UrlNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(UrlNotFoundException ex) {
      return ex.getMessage();
    }
  }

  @GetMapping("/{id}")
  public Song getOne(@PathVariable Integer id) {
    return songRepository.findById(id).orElseThrow(() -> new UrlNotFoundException());
  }

  @PostMapping
  public Song create(@RequestBody Song song) {
    return songRepository.save(song);
  }

//  @PostMapping
//  public ResponseEntity create(@Valid @RequestBody Song song, BindingResult result){
//    if (result.hasErrors()) {
//      return new ResponseEntity<List>(result.getAllErrors(),HttpStatus.NOT_ACCEPTABLE);
//    } else {
//      return new ResponseEntity<Song>(songRepository.save(song),HttpStatus.CREATED);
//    }
//  }
}
