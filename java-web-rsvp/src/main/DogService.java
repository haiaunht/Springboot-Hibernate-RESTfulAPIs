package com.launchacademy.dogs.services;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import com.launchacademy.dogs.models.Dog;

public class DogService {
  private EntityManager em;

  public DogService(EntityManager em) {
    this.em = em;
  }

  public boolean save(Dog dog) {
    try {
      em.getTransaction().begin();
      em.persist(dog);
      em.getTransaction().commit();
      return true;
    } catch (Exception exc) {
      em.getTransaction().rollback();
      return false;
    }
  }

  public List<Dog> findAll() {
    TypedQuery<Dog> query = em.createQuery("SELECT d FROM Dog d ORDER BY lastName, firstName", Dog.class);
    return query.getResultList();
  }

}
