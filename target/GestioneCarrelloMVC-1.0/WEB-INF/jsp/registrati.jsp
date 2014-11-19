<%-- 
    Document   : registrati
    Created on : 14-ott-2014, 9.44.45
    Author     : corsojava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrati</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="container-fluid">
            <div clas="headr">
                <div class="row">
                    <div class="col-md-2"><img class="img-thumbnail logo" src="img/e-commerce.gif"></div>
                    <div class="col-md-10"><h3><spring:message code="registrazione.welcome" /></h3></div>
                </div>
            </div>
            <div class="parteCentrale">
                <form:form commandName="utente" action="registrati.do">
                     <label for="nomeCognome"><spring:message code="nomeCognome" /> </label>
                     <form:input path="nomeCognome"/><br/>
                     <%--<form:errors path="nomeCognome" cssClass="error" /><br/>--%>
                     <label for="userName">Username: </label>
                     <form:input path="userName" /> <br />
                     <form:errors path="userName" cssClass="error" /><br/>
                    <label for="password">Password:</label>
                     <form:password path="password" /> <br />
                     <form:errors path="password" cssClass="error" /><br/>
                    <input type="submit" value="Registrati" /> <br />
                </form:form>
            </div>
            <div class="row">
                <p class="text-danger col-md-6"><strong>${messaggio}</strong></p>
            </div>
            <div class="footer">
                <div class="col-md-12"><span class="glyphicon glyphicon-copyright-mark">Cristian Dionisio</span></div>
            </div>
        </div>          
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>