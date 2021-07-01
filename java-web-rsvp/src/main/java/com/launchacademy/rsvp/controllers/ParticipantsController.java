package com.launchacademy.rsvp.controllers;

import com.launchacademy.admin.models.Event;
import com.launchacademy.admin.services.EventService;
import com.launchacademy.rsvp.models.Participant;
import com.launchacademy.rsvp.services.RsvpsService;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@WebServlet(urlPatterns = {"/rsvps/new", "/rsvps"})
public class ParticipantsController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    EntityManager em = getEmf().createEntityManager();
    if (req.getServletPath().equals("/rsvps/new")) {
      EventService eventService = new EventService(em);
      String eventId = req.getParameter("eventId");
      if (eventId != null && eventId != "") {
        Event event = eventService.findOne(eventId);
        req.setAttribute("event", event);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/rsvps/new.jsp");
        dispatcher.forward(req, resp);
      }
    }
    else if(req.getServletPath().equals("/rsvps")) {
      try {
        String participantId = req.getParameter("participantId");
        RsvpsService rsvpsService = new RsvpsService(em);

        if (participantId != null && participantId != "") {
          Participant participant = rsvpsService.findOne(participantId);
          if (participant != null) {
            req.setAttribute("participant", participant);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/rsvps/show.jsp");
            dispatcher.forward(req, resp);
          } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
          }
        } else {
          req.setAttribute("rsvps", rsvpsService.findAll());
          RequestDispatcher dispatcher = req.getRequestDispatcher("/views/rsvps/index.jsp");
          dispatcher.forward(req, resp);
        }
      }
      finally {
        em.close();
      }

    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getServletPath().equals("/rsvps/new")) {
      String eventId = req.getParameter("eventId");
      EntityManager em = getEmf().createEntityManager();
      EventService eventService = new EventService(em);

      Event event = eventService.findOne(eventId);

      Participant participant = new Participant();
      participant.setEvent(event);
      participant.setFirstName(req.getParameter("firstName"));
      participant.setLastName(req.getParameter("lastName"));
      participant.setEmail(req.getParameter("email"));
      participant.setPhone(req.getParameter("phone"));
      participant.setContactType(req.getParameter("contactType"));

      ValidatorFactory vf = getVf();
      Validator val = vf.getValidator();

      //RsvpsService service = new RsvpsService(em);
      RsvpsService service = new RsvpsService(em, val);
      if(!service.save(participant)) {
        System.out.println("Not saving");
      }

      resp.sendRedirect("/");
      em.close();

    }
    else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }

  private ValidatorFactory getVf() {
    return (ValidatorFactory) this.getServletContext().getAttribute("vf");
  }

}
