package com.launchacademy.orders.controllers;

import com.launchacademy.orders.models.Order;
import com.launchacademy.orders.services.OrderService;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/orders/new", "/orders"})
public class OrdersController extends HttpServlet {
  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getServletPath().equals("/orders/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/form.jsp");
      dispatcher.forward(req, resp);
    }
    else if(req.getServletPath().equals("/orders")) {

      EntityManager em = getEmf().createEntityManager();
      try {
        String orderId = req.getParameter("orderId");
        OrderService gamesService = new OrderService(em);

        if (orderId != null && orderId != "") {
          Order order = gamesService.findOne(orderId);
          if (order != null) {
            req.setAttribute("order", order);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/show.jsp");
            dispatcher.forward(req, resp);
          } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
          }
        } else {
          req.setAttribute("orders", gamesService.findAll());
          RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");
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
    if (req.getServletPath().equals("/orders")) {
      Order order = new Order();
      try {
        BeanUtils.populate(order, req.getParameterMap());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }

//      //Cookie
//      Cookie orderCookie = new Cookie("usernameCookie", order.getUsername());
//      orderCookie.setMaxAge(60*60*24);
//      resp.addCookie(orderCookie);

      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();
      OrderService service = new OrderService(em);
      if (!service.save(order)) {
        System.out.println("Not saving");
      }
      resp.sendRedirect("/orders");
      em.close();

    } else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }

}
