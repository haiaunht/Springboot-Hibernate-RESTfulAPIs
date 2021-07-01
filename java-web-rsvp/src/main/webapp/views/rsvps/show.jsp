<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="participant" value="${requestScope.participant}" />

<!DOCTYPE html>
<html>
<head>
    <title>Rsvp</title>
</head>
<body>
<h1>Current Rsvp</h1>
<h3>Name: <c:out value="${participant.firstName}"/>, <c:out value="${participant.lastName}"/></h3>
<p>Email: <c:out value="${participant.email}"/></p>
<p>Phone: <c:out value="${participant.phone}"/></p>
<p>Contact by: <c:out value="${participant.contactType}"/></p>

<p><a href="/rsvps">Back To Rsvps List</a></p>

</body>
</html>