<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Book</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<h1>New Book</h1>
<form action="/books" method="post" modelAttribute="book">
    <p>
        <label for = "1" path="title">Title</label>
        <errors path="title"/>
     	<input type = "text" name = "title" path="title" id = "1">
    </p>
    <p>
        <label for = "2"  path="description">Description</form:label>
        <errors path="description"/></label>
        <textarea name = "description" id = "2" path="description"></textarea></p>
    <p>
        <label for = "3" path="language">Language</form:label>
        <errors path="language"/>
        <input path="language" type = "text" name = "language" id = "3">
    </p>
    <p>
        <label for = "4" path="numberOfPages">Pages</label>
        <errors path="numberOfPages"/>
        <input type = "number" name = "numberOfPages" path="numberOfPages">
    </p>    
    <button>Submit</button>
</form>    
</body>
</html>