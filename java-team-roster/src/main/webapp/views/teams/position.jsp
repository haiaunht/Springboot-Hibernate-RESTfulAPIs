<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.launchacademy.League" %>
<!DOCTYPE html>
<html>
<head>
    <title>Positions</title>
</head>
<body>
<h1>List of Positions</h1>
<ul>
    <c:forEach var="position" items="${requestScope.positions}">
        <li>
            <a href="/position?name=<c:out value="${position}"/>">
                <c:out value="${position}"/>
            </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
