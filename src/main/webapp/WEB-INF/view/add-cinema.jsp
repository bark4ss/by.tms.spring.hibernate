<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="saveCinema" modelAttribute="cinema">

    Name:<form:input path="name"/>
    <br>
    <br>
    Address:<form:input path="address"/>
    <br>
    <br>
<%--    Film name:<form:input path="f"/>--%>

    <input type="submit" value="OK"/>

</form:form>

</body>
</html>
