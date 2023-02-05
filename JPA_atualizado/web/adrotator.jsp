<%-- 
    Document   : adorator
    Created on : 15 de dez de 2022, 22:21:19
    Author     : Michel
--%>

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
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@page import="prototipo.Rotator" %>

        <jsp:useBean id="rotator" scope="session" class="prototipo.Rotator" />

        <% rotator.nextAd(); %>


            <p> 
                <a href="<jsp:getProperty name="rotator" property="link" />" target="_blank">        
                    <img src ="<jsp:getProperty name="rotator" property="image" />" alt="advertisemont"/>
                </a>
            </p>

   </body>
</html>

