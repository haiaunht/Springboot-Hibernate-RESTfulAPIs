<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="list" value="${requestScope.list}" />
<c:set var="map" value="${requestScope.map}" />

<!DOCTYPE html>
<html>
<head>
    <title>Font Awesome 5 Icons</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <!--Get your own code at fontawesome.com-->
</head>

<body>
<!-- Your View Logic Here -->
<h1>Batch Rolls</h1>
<div>
    <c:forEach items="${list}" var="each">
        <c:forEach items="${map.get(each)}" var="dice">
            <c:choose>
                <c:when test="${dice == 1}" >
                    <i class="fas fa-dice-one"></i>
                </c:when>
                <c:when test="${dice == 2}" >
                    <i class="fas fa-dice-two"></i>
                </c:when>
                <c:when test="${dice == 3}" >
                    <i class="fas fa-dice-three"></i>
                </c:when>
                <c:when test="${dice == 4}" >
                    <i class="fas fa-dice-four"></i>
                </c:when>
                <c:when test="${dice == 5}" >
                    <i class="fas fa-dice-five"></i>
                </c:when>
                <c:when test="${dice == 6}" >
                    <i class="fas fa-dice-six"></i>

                </c:when>
            </c:choose>
        </c:forEach>
    <c:out value="${each.result}"/><br>
    </c:forEach>
</div>

</body>
</html>