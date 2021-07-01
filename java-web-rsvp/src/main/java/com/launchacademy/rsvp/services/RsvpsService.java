package com.launchacademy.rsvp.services;

import com.launchacademy.rsvp.models.Participant;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

public class RsvpsService {
  private EntityManager em;
  private Validator val;

  public RsvpsService(EntityManager em) {
    this.em = em;
  }

  public RsvpsService(EntityManager em, Validator val ) {
    this.em = em;
    this.val = val;
  }

  public boolean save(Participant participant) {
    boolean valid = true;

    if (valid) {
      Set<ConstraintViolation<Participant>> violations = val.validate(participant);
      if(violations.size() > 0) {
        valid = false;
        System.out.println("Invalid input: please address the following issues");
        for (ConstraintViolation<Participant> violation : violations) {
          System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        }
      }
      try {
        em.getTransaction().begin();
        em.persist(participant);
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

  public List<Participant> findAll() {
    TypedQuery<Participant> query = em.createQuery("SELECT p FROM Participant p ORDER BY lastName, firstName", Participant.class);
    return query.getResultList();
  }

  public Participant findOne(String participantId) {
    String queryString = "SELECT p from Participant p where id = :participantId";
    TypedQuery<Participant> query = em.createQuery(queryString, Participant.class);
    Participant participant = null;
    try {
      query.setParameter("participantId", Long.parseLong(participantId));
      participant = query.getSingleResult();
    } catch (Exception exception) {
      System.out.println("There is no matching record");
    }
    return participant;
  }
}