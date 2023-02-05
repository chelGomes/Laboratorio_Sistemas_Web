<%-- 
    Document   : Menu_Prototipo
    Created on : 9 de nov de 2022, 09:24:29
    Author     : Michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <style>
            .jumbotron {
                background-color: #2E8B57;
                color: #fff;
                padding: 100px 25px;
            }

            .container-fluid {
             padding: 60px 50px;
           }
        </style>
        
    </head>
    <body>
        <div class="jumbotron text-center">
        <h1>MENU</h1>
        <a href="Control_Sessao_Prototipo?code=welcome">Welcome</a>
        <a href="Control_Sessao_Prototipo?code=sair">Sair</a>
        <a href="Control_Sessao_Prototipo?code=erroJava">Erro java</a>
        <a href="Control_Sessao_Prototipo?code=erro404">Erro 404</a>
        <a href="Control_Sessao_Prototipo?code=ajudaMvc"> Ajuda </a>
        <a href="Control_Sessao_Prototipo?code=lista">list_jpa</a>
        
         <% Object obj = getServletContext().getAttribute("userCounter"); %>
         <p><br>Lista de Usuarios: <%= obj %></p>
        
        </div>
    </body>
</html>
