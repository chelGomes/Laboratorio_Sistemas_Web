<%-- 
    Document   : list_jpa
    Created on : 22 de dez de 2022, 22:09:36
    Author     : Michel
--%>

<%@page import="model.UsuarioJsp"%>
<%@page import="java.util.List"%>
<%@page import="model.UsuarioJspJpaController"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prototipo II</title>
        
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
        <h1>Lista de Usuarios: </h1>
        </div>
    </body>
            <%
                  EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_atualizadoPU");
                  UsuarioJspJpaController utx = new UsuarioJspJpaController(null,emf);
                  List<UsuarioJsp> U = utx.findUsuarioJspEntities();
                  for(UsuarioJsp i: U){ %>
                  <p><%=i.getUsuario()%></p>
                  <%
                  
                    }
                   emf.close();
                %> 
                <a href="index.jsp">Voltar para o Menu</a>
                </div>
    </body>
    
    
</html>
