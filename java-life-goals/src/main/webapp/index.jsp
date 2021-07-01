<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Hello from JSP</title>
  </head>
  <body>
    <h2>Life Goals</h2>
    <ul>
    <%
      List<String> tasks = new ArrayList<String>();
      tasks.add("Learn JSP this week");
      tasks.add("Get to know Tomcat :).");
      tasks.add("Buy more boba ice cream.");
      for (String task : tasks) {
      %>
        <li><%= task %></li>
      <% }
    %>
    </ul>
  </body>
</html>