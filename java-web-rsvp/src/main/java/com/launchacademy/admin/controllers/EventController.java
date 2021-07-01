package com.launchacademy.admin.controllers;

import com.launchacademy.admin.models.Event;
import com.launchacademy.admin.services.EventService;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/admin/events/new", "/admin/rsvps", "/admin/events", "/"})
public class EventController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    if (req.getServletPath().equals("/admin/events/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/new.jsp");
      dispatcher.forward(req, resp);
    }
    else if(req.getServletPath().equals("/") ) {
      EntityManager em = getEmf().createEntityManager();
      try {
        EventService events = new EventService(em);
        req.setAttribute("events", events.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/index.jsp");
        dispatcher.forward(req, resp);
      }
      finally {
        em.close();
      }
    }
    else if (req.getServletPath().equals("/admin/rsvps")) {
      EntityManager em = getEmf().createEntityManager();
      try {
        String eventId = req.getParameter("eventId");
        EventService events = new EventService(em);
        if (eventId != null && eventId != "") {
          Event event = events.findOne(eventId);
          if (event != null) {
            req.setAttribute("event", event);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/show.jsp");
            dispatcher.forward(req, resp);
          } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
          }
        }
      }finally {
        em.close();
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getServletPath().equals("/admin")) {
      Event event = new Event();
      try {
        BeanUtils.populate(event, req.getParameterMap());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();

      ValidatorFactory vf = getVf();
      Validator val = vf.getValidator();

      EventService service = new EventService(em, val);
      if (!service.save(event)) {
        System.out.println("Not saving");
      }

      resp.sendRedirect("/");
      em.close();

    } else {
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
