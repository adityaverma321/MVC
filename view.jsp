<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="mvc.bean.Bean" %>
    <%
          ArrayList<Bean> students=(ArrayList<Bean>)request.getAttribute("students");
          for(Bean student:students)
          {
             out.print(student.getRoll()+ " ");
             out.print(student.getFname()+ " ");
             out.print(student.getLname()+ " ");
             out.print("<br/>");

          }
    %>
</body>
</html>
