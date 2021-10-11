<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="language_bar.jsp"/>
<h2>${message}</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Address</th>
    </tr>
    <c:forEach var="cinema" items="${allCinemas}">
        <tr>
            <td>${cinema.name}</td>
            <td>${cinema.address}</td>
            <td><a href="/cinema/${cinema.id}"><spring:message code="cinema.details"/> </a></td>
        </tr>

    </c:forEach>
</table>

<form:form action="/cinema/add" method="post" modelAttribute="cinema">
    <table>
        <tr>
            <td><h2><spring:message code="cinema.title"/></h2></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><form:input path="address" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add cinema" /></td>
        </tr>
    </table>
</form:form>

</body>
</html>
