package com.launchacademy.javacoffeeshop.controllers;

import com.launchacademy.javacoffeeshop.models.Product;
import com.launchacademy.javacoffeeshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/products")
public class ProductsController {
  private ProductService productService;

  @Autowired
  public ProductsController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public String getProductList(Model model) {
    model.addAttribute("products", productService.findAll());
    return "products/index";
  }

  @GetMapping("/show/{productId}")
  public String getProductById(@PathVariable Integer productId, Model model) {
    model.addAttribute("product", productService.get(productId));
    return "products/show";
  }

  @GetMapping("/new")
  public String addNewProduct(@ModelAttribute Product product) {
    return "products/new";
  }

  @PostMapping
  public String createNewProduct(@ModelAttribute Product product) {
    int id = productService.findAll().size() + 1;
    product.setId(id);
    productService.addToList(product);
    return "redirect:/products" ;
  }

  @GetMapping("/delete/{id}")
  public String deleteProduct(@ModelAttribute Product product, @PathVariable Integer id) {
    productService.removeProduct(id);
    return "redirect:/products";
  }

  //other way
//  @DeleteMapping("/show/{productId}")
//  public String deleteProduct(@PathVariable Integer productId) {
//    productService.deleteProduct(productId);
//    return "redirect:/products";
//  }
}
