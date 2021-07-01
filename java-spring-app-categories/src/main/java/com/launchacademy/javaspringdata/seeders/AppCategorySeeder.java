package com.launchacademy.javaspringdata.seeders;

import com.launchacademy.javaspringdata.models.AppCategory;
import com.launchacademy.javaspringdata.repositories.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCategorySeeder implements CommandLineRunner {
  private CategoryRepository categoryRepository;

  @Autowired
  public AppCategorySeeder(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    List<String> categories = new ArrayList<>();
    categories = List.of("Social Media", "Productivity", "Games", "Self Help");

    //loop through the collection, creating app ideas if they're not found
    for(String name : categories) {
      List<AppCategory> all = categoryRepository.findAllByName(name);
      if(all.size() == 0) {
        AppCategory category = new AppCategory();
        category.setName(name);
        categoryRepository.save(category);
      }
    }
  }
}
