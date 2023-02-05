<%-- 
    Document   : adorator
    Created on : 15 de dez de 2022, 22:21:19
    Author     : Michel
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="prototipo.Rotator" %>

<jsp:useBean id="rotator" scope="session" class="prototipo.Rotator" />

<% rotator.nextAd(); %>


<p> 
    <a href="<jsp:getProperty name="rotator" property="link" />" target="_blank">        
        <img src ="<jsp:getProperty name="rotator" property="image" />" alt="advertisemont"/>
    </a>
</p>
