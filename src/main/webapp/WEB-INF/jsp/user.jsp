<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table>
     <tr>
       <td>id</td>
       <td>name</td>
       <td>age</td>
       <td>score</td>
     </tr>
     <c:forEach items="${user}" var="u" >
       <tr>
         <td>${u.id}</td>
         <td>${u.name}</td>
         <td>${u.age}</td>
         <td>${u.score}</td>
       </tr>
     </c:forEach>
   </table>
</body>
</html>