package com.launchacademy;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

@WebListener
public class EMFListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent event) {
    EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("com.launchacademy.javaWebRsvps");
    event.getServletContext().setAttribute("emf", emf);

    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    event.getServletContext().setAttribute("vf", vf);
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    EntityManagerFactory emf = (EntityManagerFactory)event.getServletContext().getAttribute("emf");
    if(emf != null) {
      emf.close();
    }
    ValidatorFactory vf = (ValidatorFactory) event.getServletContext().getAttribute("vf");
    vf.close();
  }
}
