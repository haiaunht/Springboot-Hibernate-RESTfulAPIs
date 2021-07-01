<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.launchacademy.League" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="name" value="${requestScope.name}" scope="request" />
<c:set var="playersList" value="${requestScope.playersList}" scope="request" />
<c:set var="match" value="${requestScope.matchTeamName}"  />
<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${name}" /></title>
</head>
<body>
<h1>Postion: <c:out value="${name}" /></h1>

<h2>Players:</h2>
<ul>
    <c:forEach var="player" items="${playersList}">
        <li>
            <c:out value="${player.name}"/>
        </li>
    </c:forEach>
</ul>
</body>
</html>