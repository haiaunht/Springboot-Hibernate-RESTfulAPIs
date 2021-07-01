package com.launchacademy.donutTracker.controllers;

import com.launchacademy.donutTracker.models.Donut;
import com.launchacademy.donutTracker.repositories.DonutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donuts")
public class DonutsController {

  @Autowired
  private DonutRepository donutRepository;

  @GetMapping
  public String paginatedListOfDonut(Pageable pageable, Model model) {
    //model.addAttribute("donuts", donutRepository.findAll(pageable));
    model.addAttribute("donuts", donutRepository.findByOrderByType(pageable));
    return "donuts/index";
  }

  @GetMapping("/new")
  public String donutForm(@ModelAttribute("donut") Donut donut) {
    return "donuts/new";
  }

  @PostMapping
  public String createForm(@ModelAttribute("donut") Donut donut) {
    donutRepository.save(donut);
    return "redirect:/donuts";
  }
}
