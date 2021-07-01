package com.launchacademy.donutTracker.controllers;

import com.launchacademy.donutTracker.models.Donut;
import com.launchacademy.donutTracker.repositories.DonutRepository;
import java.util.List;
import javax.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/v1/donuts")
public class DonutsRestController {

  @Autowired
  private DonutRepository donutRepository;

  @GetMapping
  public Iterable<Donut> displayAllDonuts(Pageable pageable) {
    return donutRepository.findByOrderByType(pageable);
  }

  @GetMapping("/{id}")
  public Donut displayDonut(@PathVariable Integer id) {
    //return donutRepository.findById(id).get();
    return donutRepository.findById(id).orElseThrow(() -> new DonutNotFoundException());
  }

  @NoArgsConstructor
  private class DonutNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class DonutNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DonutNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(DonutNotFoundException ex) {
      return "Donut not found";
    }
  }

//  @PostMapping
//  public Donut create(@RequestBody Donut donut) {
//    return donutRepository.save(donut);
//  }

  @PostMapping
  public ResponseEntity create(@Valid @RequestBody Donut song, BindingResult result){
    if (result.hasErrors()) {
      return new ResponseEntity<List>(result.getAllErrors(),HttpStatus.NOT_ACCEPTABLE);
    } else {
      return new ResponseEntity<Donut>(donutRepository.save(song),HttpStatus.CREATED);
    }
  }
  //curl -X POST localhost:8080/api/v1/donuts -H 'Content-type:application/json' -d '{"type":"cddon", "description": "cripsy", "vegan": false}'
}
