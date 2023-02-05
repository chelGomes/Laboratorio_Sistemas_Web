<%-- 
    Document   : usuario
    Created on : 30 de out de 2022, 01:05:54
    Author     : Michel
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Usuário </h1>
        <%
            ArrayList<String> nomes = (ArrayList<String>) request.getAttribute("nomes");
            for (int i = 0; i < nomes.size(); i++) {
        %>

        <p class="lista" ><%= nomes.get(i)%></p>  
        <br>  
        <%
            }
        %>
        <h2><a href="Redireciona_jsp">Sair</a></h2>
    </body>
</html>
