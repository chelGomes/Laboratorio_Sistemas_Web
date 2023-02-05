<%-- 
    Document   : login
    Created on : 30 de out de 2022, 01:00:54
    Author     : Michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h2>UFJF - Depto. de Ciencia da Computacao </h2>
        <h2>Laboratorio de Programacao de Sistemas Web</h2>
        <h1>Prototipo I - Michel Andrade</h1>     
    </center>
        <form action="Menu_Banco_Dados_jsp" method ="post">
            <div>
                <label for="usuario">Usuário</label>
                <input type="text" name="usuario">
                <label for="senha">Senha</label>        
                <input type="password" name="senha">
                <button type="submit">Ok</button>
            </div>
        </form> 
    </body>
</html>
