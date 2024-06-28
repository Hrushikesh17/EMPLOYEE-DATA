<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kick out</title>
</head>
<body>
<form:form action="delete" modelAttribute="employee">
<form:label path="id">Enter Id</form:label>
<form:input path="id"/>
<input value="DELETE" type="submit">
</form:form>
</body>
</html>