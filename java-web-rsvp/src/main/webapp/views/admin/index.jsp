<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="com.launchacademy.admin.models.Event" %>


<div>
    <h2>All events!</h2>
    <ul>
        <c:forEach items="${requestScope.events}" var="event">
            <li>
                <a href="/rsvps/new?eventId=<c:out value="${event.id}"/>">
                    <c:out value = "${event.title}" />
                </a>, <c:out value = "${event.city}, ${event.state}" />
                <p>(<a href="/admin/rsvps?eventId=${event.id}">${event.title}'s Detail</a>)</p>
            </li>
        </c:forEach>
    </ul>
    <a href="/admin/events/new">Add a Event!</a>
</div>
