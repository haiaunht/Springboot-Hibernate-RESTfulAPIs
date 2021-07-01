import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(urlPatterns = "/hello")
public class MyFirstServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String greeting = "";
    String lang = req.getParameter("lang");
    if ("fr".equals(lang)) {
      greeting = "Bonjour";
    }
    else if ("es".equals(lang)){
      greeting = "Hola";
    } else {
      greeting = "Hello";
    }

    String firstName = req.getParameter("first_name");
    String lastName = req.getParameter("last_name");

    if(firstName != null && firstName != "" && lastName != null && lastName != "") {
      greeting += ", " + firstName + " " + lastName;
    } else if (firstName == null && lastName != null && lastName != "" ) {
      greeting += ", " + lastName;
    }

    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/greetings/show.jsp");
    req.setAttribute("greeting", greeting);
    dispatcher.forward(req, resp);
  }
}