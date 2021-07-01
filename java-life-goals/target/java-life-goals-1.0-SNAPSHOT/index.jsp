<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Hello from JSP</title>
  </head>
  <body>
    <h2>Life Goals</h2>
    <%
      List<String> tasks = List.of("Learn JSP", "Get to know Tomcat", "Have fun while learning!");
      for(int i = 0; i < tasks.size(); i++) {
      %>
      <p>The date is <%= tasks.get(i) %></p>
      <% }

    %>
  </body>
</html>