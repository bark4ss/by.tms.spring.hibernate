<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Name: ${cinema.name}</p>
<p>Address: ${cinema.address}</p>

<c:forEach var="film" items="${cinema.films}" varStatus="loop">

    <p>${loop.count} Film Name: ${film.name} | Film Description: ${film.description} | Date: ${film.date} | Time: ${film.time} | Price: ${film.cost}</p>

</c:forEach>

<form:form action="/film/add" method="post" modelAttribute="film">
    <table>
        <tr>
            <td><h2>Add new Film</h2></td>
        </tr>
        <form:hidden path="cinema.id" value="${cinema.id}" />
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td>Cost:</td>
            <td><form:input path="cost" /></td>
        </tr>
        <tr>
            <td>Date:</td>
            <td><form:input type="date" path="date" /></td>
        </tr>
        <tr>
            <td>Time:</td>
            <td><form:input type="time" path="time" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add cinema" /></td>
        </tr>
    </table>
</form:form>

</body>
</html>
