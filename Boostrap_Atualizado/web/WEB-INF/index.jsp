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
        <title>Prototipo II</title>
    </head>
    <body>
        <center> 
        <div class="container mt-3">
            <div class="bg-dark p-3">
                <h1> UFJF - Depto. de Ciencia da Computacao</h1>
            </div>
            <div class="bg-light p-3"> Laboratorio de Programacao de Sistemas Web</div>
            <div class="bg-light p-3">Prototipo II - Michel Andrade</div>
        </div>
  
        <!--<h2>UFJF - Depto. de Ciencia da Computacao </h2>
        <h2>Laboratorio de Programacao de Sistemas Web</h2>
        <h1>Prototipo II - Michel Andrade</h1> -->    
        <div class="container mt-3">
            <img class="img-fluid" src="download.jpg" alt="New York" width="1100" height="500"> 
        </div>
       <!--<img src="download.jpg" class="rounded" alt="Cinque Terre">-->
         <form action="Control_Sessao_Prototipo" method="post">
            <div>
                <label for="nomeusuario">NomeUsuário</label>
                <input type="text" name="Prototipo">
                <label for="senha">Senha</label>        
                <input type="password" name="senhabd"></br>
                </br><button type="submit" class="btn btn-secondary">Ok</button>
            </div>
        </form>
     <!--<div class="p-3 mb-2 bg-primary text-white">.bg-primary</div>-->
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


<div class="container-fluid">
  ...
</div>