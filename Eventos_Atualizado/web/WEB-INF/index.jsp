<%-- 
    Document   : index
    Created on : 9 de nov de 2022, 03:13:49
    Author     : Michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Prototipo I  v.1</title>
    </head>
    <body>
        <center>
        <h2>UFJF - Depto. de Ciencia da Computacao </h2>
        <h2>Laboratorio de Programacao de Sistemas Web</h2>
        <h1>Prototipo II - Michel Andrade</h1>     
    
       
         <form action="Control_Sessao_Prototipo" method="post">
            <div>
                <label for="nomeusuario">NomeUsuário</label>
                <input type="text" name="Prototipo">
                <label for="senha">Senha</label>        
                <input type="password" name="senhabd"></br>
                </br><button type="submit">Ok</button>
            </div>
        </form>
        
         <%
             Object obj = session.getAttribute("msg");
             if(obj != null){
             %>
             <p> <%= obj %></p>
             <%
                 }
                %>
       </center>  
    </body>
</html>
