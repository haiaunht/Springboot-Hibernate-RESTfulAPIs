import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/greetings/new", "/greetings"})
public class GreetingsController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/greetings/new.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if(req.getServletPath().equals("/greetings")) {
      Greeting greeting = new Greeting();

      //this is with commons-beanutils dependency
      try {
        BeanUtils.populate(greeting, req.getParameterMap());
      }
      catch(IllegalAccessException ex) {
        //do some logging
      }
      catch(InvocationTargetException ex) {
        //do some logging
      }
      req.setAttribute("greeting", greeting);
//      greeting.setFirstName(req.getParameter("firstName"));
//      greeting.setLastName(req.getParameter("lastName"));
//      greeting.setLanguage(req.getParameter("language"));
//      req.setAttribute("greeting", greeting);

      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/greetings/show.jsp");
      dispatcher.forward(req, resp);
    }
    else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

}