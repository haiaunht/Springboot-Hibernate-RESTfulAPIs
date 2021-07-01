<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Donut Orders</title>
  </head>
  <body>
    <%
      Map<String, Integer> donutOrders = new HashMap<String, Integer>();
      donutOrders.put("Jennifer", 10);
      donutOrders.put("Alex", 1);
      donutOrders.put("Carly", 3);
      request.setAttribute("donutOrders", donutOrders);
      Set<String> names = donutOrders.keySet();

      Map<String, String> favoriteDonuts = new HashMap<String, String>();
      favoriteDonuts.put("Jennifer", "Glazzy");
      favoriteDonuts.put("Alex", "Black Jack");
      favoriteDonuts.put("Carly", "Green tease");
      request.setAttribute("favoriteDonuts", favoriteDonuts);
    %>

    <h2>Donut Orders</h2>
    <p> <%= (new Date()).toLocaleString() %> </p>
    <ul>
      <%
        int totalDonuts = 0;
        for(Map.Entry<String, Integer> order : donutOrders.entrySet()) {
          String name = order.getKey();
          int donutNum = order.getValue();
          String message = "";
          String favorite = "";
          if(order.getValue() <= 5){
            totalDonuts += order.getValue();
          } else {
            totalDonuts += 2;
            donutNum = 2;
            message = "This person tried to order more than 5 donuts";
          }
          if(favoriteDonuts.containsKey(name) ){
            favorite = "(" + favoriteDonuts.get(name) + " donuts are this person's favorite)";
          }
      %>
      <li> Name <%=name%> : <%=donutNum%> <%= favorite %> <%= message %> </li>
      <%
        }
      %>
    </ul>
    <p> Total Donuts: <%= totalDonuts %> </p>

<%--    <h2>Donut Orders</h2>--%>
<%--    <p>Today's date is: <%= new java.util.Date().toLocaleString()%> </p>--%>
<%--    <ul>--%>
<%--      <%--%>
<%--        int totalCount = 0;--%>
<%--        for (String name : names) { %>--%>
<%--          <% if(donutOrders.get(name) <= 5) { %>--%>
<%--             <li><%= name%>: <%= donutOrders.get(name)%> Donuts</li>--%>
<%--          <% }  %>--%>

<%--          <% if(donutOrders.get(name) > 5) { %>--%>
<%--            <li><%= name%>: <%= "We should talk! 2 Donuts for this week :)."%></li>--%>
<%--            <% donutOrders.put(name, 2); %>--%>
<%--          <% }  %>--%>
<%--        <% totalCount += donutOrders.get(name);%>--%>
<%--      <% } %>--%>
<%--    </ul>--%>
<%--    <p>The total number of donuts: <%=totalCount%></p>--%>

<%--    <ul>--%>
<%--    <c:forEach items="${favoriteDonuts}" var="fav">--%>
<%--      <li><c:out value="${fav.key}'s favorite Donut is: ${fav.value}"/></li>--%>
<%--    </c:forEach>--%>
<%--    </ul>--%>
  </body>
</html>