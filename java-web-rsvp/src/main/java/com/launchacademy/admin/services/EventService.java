package com.launchacademy.admin.services;

import com.launchacademy.admin.models.Event;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

public class EventService {
  private EntityManager em;
  private Validator val;

  public EventService(EntityManager em) {
    this.em = em;
  }

  public EventService(EntityManager em, Validator val ) {
    this.em = em;
    this.val = val;
  }

  public boolean save(Event event) {
    boolean valid = true;

    if (valid) {
      Set<ConstraintViolation<Event>> violations = val.validate(event);
      if(violations.size() > 0) {
        valid = false;
        System.out.println("Invalid input: please address the following issues");
        for (ConstraintViolation<Event> violation : violations) {
          System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
      }
      try {
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
        return true;
      } catch (Exception exc) {
        //an error occurred with the INSERT so return false
        em.getTransaction().rollback();
        return false;
      }
    }
    return false;
  }

  public List<Event> findAll() {
    TypedQuery<Event> query = em.createQuery("SELECT p FROM Event p ORDER BY title", Event.class);
    return query.getResultList();
  }

  public Event findOne(String eventId) {
    String queryString = "SELECT e from Event e where id = :eventId";
    TypedQuery<Event> query = em.createQuery(queryString, Event.class);
    Event event = null;
    try {
      query.setParameter("eventId", Long.parseLong(eventId));
      event = query.getSingleResult();
    } catch (Exception exception) {
      System.out.println("There is no matching record");
    }
    return event;
  }

}
