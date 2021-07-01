<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="com.launchacademy.rsvp.models.Participant" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="rsvps" value="${requestScope.rsvps}" />

<div>
    <ul>
        <c:forEach items="${rsvps}" var="rsvp">
            <li><a href="/rsvps?participantId=<c:out value="${rsvp.id}"/>">
                <c:out value="${rsvp.firstName}" />
                <c:out value="${rsvp.lastName}"/></a></li>
        </c:forEach>
    </ul>
    <a href="/rsvps/new">Add new</a>
</div>
