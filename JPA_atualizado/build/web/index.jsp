<%-- 
    Document   : index
    Created on : 25 de dez de 2022, 15:32:13
    Author     : Michel
--%>

<%@page import="java.util.List"%>
<%@page import="model.UsuarioJsp"%>
<%@page import="model.UsuarioJspJpaController"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Prototipo II</title>
        
       <style>
            .jumbotron {
                background-color: #2E8B57;
                color: #fff;
                padding: 100px 25px;
            }

            .container-fluid {
             padding: 100px 50px;
           }
        </style>
        
    </head>
    <body>
       <center> 
        <div class="jumbotron text-center">
            <center><h1> UFJF - Depto. de Ciencia da Computacao</h1></center>
                <div class="bg-light p-3"> Laboratorio de Programacao de Sistemas Web</div>
                <div class="bg-light p-3">Prototipo II - Michel Andrade</div></br>
             <!--<form class="form-inline">-->
            
                 <div class="container mt-3">
                     <center><img class="img-fluid" src="tecnologia-informacao.jpg" alt="New York" width="800" height="500"> </center></br>  
                </div>
             
             
                <form action="Control_Sessao_Prototipo" method="post">
                    <div class="input-group">
                        <label for="nomeusuario">Nome Usuário:</label>
                        <input type="text" name="Prototipo">
                        <label for="senha">Senha:</label>  
                        <input type="password" name="senhabd"></br>
                            <div class="input-group-btn">
                                <button type="submit" class="btn btn-secondary">Ok</button>
                            </div>
                    </div>
                </form>
        </div>
        
        <div class="container">
            <jsp:include page = "adrotator.jsp" flush = "true"/>     
        </div>
       
        <%
             Object obj = session.getAttribute("msg");
             if(obj != null){
        %>
             <p> <%= obj %></p>
             <%
                }
              %>
                
                <%
                  EntityManagerFactory emf = Persistence.createEntityManagerFactory("michelPU");
                  UsuarioJspJpaController utx = new UsuarioJspJpaController(null,emf);
                  List<UsuarioJsp> U = utx.findUsuarioJspEntities();
                  for(UsuarioJsp i: U){ %>
                  <p><%=i.getUsuario()%></p>
                  <%
                  
                    }
                   emf.close();
                %> 
         </center>  
    </body>
</html>

<div class="container-fluid">
  ...
</div>
