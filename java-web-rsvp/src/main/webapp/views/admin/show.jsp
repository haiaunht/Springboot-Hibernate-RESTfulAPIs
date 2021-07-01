<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="event" value="${requestScope.event}" />

<!DOCTYPE html>
<html>
<head>
    <title>Event</title>
</head>
<body>
<h1>Current Event</h1>
<h3>Title: <c:out value="${event.title}"/></h3>
<p>Street: <c:out value="${event.street}"/></p>
<p>City: <c:out value="${event.city}"/></p>
<p>State: <c:out value="${event.state}"/></p>
<p>Postal code: <c:out value="${event.postalCode}"/></p>
<p>Participants: </p>
<c:forEach items="${event.participantList}" var="participant" >
    <li>
        <c:out value="${participant.firstName} ${participant.lastName}, ${participant.email}, ${participant.phone}" />
    </li>
</c:forEach>
<br>

<p><a href="/">Back To Event List</a></p>

</body>
</html>