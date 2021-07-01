package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.AppCategory;
import com.launchacademy.javaspringdata.models.Idea;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<AppCategory, Integer> {
  public List<AppCategory> findAllByName(String name);
}
