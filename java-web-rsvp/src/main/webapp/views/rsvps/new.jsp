<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<c:set var="event" value="${requestScope.event}" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a New Rsvp</title>
</head>
<body>
<%--<form action="/rsvps" method="post">--%>
<form action="/rsvps/new" method="post">
    <div>
        <label for="firstName">First name</label>
        <input type="text" id="firstName" name="firstName" value="" />
    </div>
    <div>
        <label for="lastName">Last name</label>
        <input type="text" id="lastName" name="lastName" value="" />
    </div>
    <div>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" value=""/>
    </div>
    <div>
        <label for="phone">Phone </label>
        <input  type="text" id="phone" name="phone" placeholder="123-456-7890" value=""/>
    </div>
    <div>
        <%--@declare id="contactreference"--%><label for="contactType">Contact reference</label>
        <select id = "contactType" name="contactType">
            <option value=""></option>
            <option value="phone">Phone</option>
            <option value="text">Text</option>
        </select>
    </div>
    <div>
        <label for="eventId">Current event: ${event.title}</label>
        <input  type="text" id="eventId" name="eventId" value="${event.id}" hidden/>
    </div>
    <input type="submit" value="Reserve" />
</form>
<a href="/">Home</a>
</body>
</html>
