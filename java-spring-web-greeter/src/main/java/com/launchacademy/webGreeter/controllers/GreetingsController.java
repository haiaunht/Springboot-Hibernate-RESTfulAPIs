package com.launchacademy.webGreeter.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greetings")
public class GreetingsController {

 @GetMapping("/default")
 public String getDefaultGreeting(Model model) {
   model.addAttribute("greeting", "Hello from Spring");
   return "greetings/show";
 }

  @GetMapping("/by-query-string")
  public String getQueryStringGreeting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, Model model) {
   if (firstName != null && firstName != "" && lastName != null && lastName != "") {
     model.addAttribute("greeting", "Hello from Spring, " + firstName + " " + lastName);
   } else if (lastName == null) {
     model.addAttribute("greeting", "Hello from Spring, " + firstName);
   } else {
     model.addAttribute("greeting", "Hello from Spring, ");
   }
    return "greetings/show";
  }

  @GetMapping("/by-language/{lang}")
  public String getCustomizedGreeting(@PathVariable String lang, Model model) {
   if (lang.equalsIgnoreCase("fr")) {
     model.addAttribute("greeting", "Bonjour!");
   } else if (lang.equalsIgnoreCase("es")) {
     model.addAttribute("greeting", "Hola");
   } else if (lang.equalsIgnoreCase("en")) {
     model.addAttribute("greeting", "Hello");
   }
    return "greetings/show";
  }
}
