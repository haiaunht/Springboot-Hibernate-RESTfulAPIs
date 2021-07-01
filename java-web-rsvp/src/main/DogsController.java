package com.launchacademy.dogs.controllers;

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
import com.launchacademy.dogs.models.Dog;
import com.launchacademy.dogs.services.DogService;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/dogs/new", "/dogs"})
public class DogsController extends HttpServlet {

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    if (req.getServletPath().equals("/dogs/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dogs/new.jsp");
      dispatcher.forward(req, resp);
    }
    else if(req.getServletPath().equals("/dogs") ) {
      EntityManager em = getEmf().createEntityManager();
      try {
        DogService dogs = new DogService(em);
        req.setAttribute("dogs", dogs.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dogs/index.jsp");
        dispatcher.forward(req, resp);
      }
      finally {
        em.close();
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getServletPath().equals("/dogs")) {
      Dog dog = new Dog();
      try {
        BeanUtils.populate(dog, req.getParameterMap());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }

      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();
      DogService service = new DogService(em);

      if (!service.save(dog)) {
        System.out.println("Not saving");
      }
      resp.sendRedirect("/dogs");
      em.close();
    } else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }
}
