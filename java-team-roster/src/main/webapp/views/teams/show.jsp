<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.launchacademy.League" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="team" value="${requestScope.team}" scope="request" />
<c:set var="players" value="${requestScope.players}" scope="request" />
<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${team.teamName}" /></title>
</head>
<body>
<h1>Team: <c:out value="${team.teamName}" /></h1>
<ul>
    <c:forEach var="player" items="${players}">
        <li>
            <c:out value="${player.position}"/>: <c:out value="${player.name}"/>
        </li>
    </c:forEach>
</ul>
</body>
</html>