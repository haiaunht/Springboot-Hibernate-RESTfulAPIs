package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.Idea;
import java.util.List;
import java.util.Optional;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Integer> {

  public List<Idea> findAllByName(String name);
  public List<Idea> findAll();
  public Optional<Idea> findById(Integer id);

//  @Query("SELECT i from Idea i where i.name = :name")
//  public Idea findByName(@Param("name") String name);
// same as the JPA defining query method base on naming convention
  Idea findByName(String name);

//  @Query("SELECT i from Idea i where i.name not like %:word%")
//  public List<Idea> whichNotContainWord(@Param("word") String word);
  List<Idea> findByDescriptionNotContaining(String description);

//  @Query("SELECT i from Idea i where i.name like :namePrefix%")
//  public List<Idea> whereNameStartsWith(@Param("namePrefix") String namePrefix);
  List<Idea> findByNameStartingWith(String starWith);

//  @Query("SELECT i from Idea i where i.name like %:endWith")
//  public List<Idea> whereNameEndsWith(@Param("endWith") String endWith);
  List<Idea> findByNameEndingWith(String endWith);
}