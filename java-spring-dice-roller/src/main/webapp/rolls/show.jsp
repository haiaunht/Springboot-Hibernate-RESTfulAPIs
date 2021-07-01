<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Your View Logic Here -->
<h1>Implement Your View Logic</h1>
<div>
    <c:out value="You rolled: ${requestScope.num}" />
    <c:out value="${requestScope.result}"/>
    <c:out value="${requestScope.diceCount}"/>


</div>
<div>
    <c:forEach items="${requestScope.list}" var="each">
        <c:out value="${each.result}"/>
    </c:forEach>
</div>