<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-commerce</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="container-fluid">
            <div clas="headr">
                <div class="row">
                    <div class="col-md-2"><img class="img-thumbnail logo" src="img/e-commerce.gif"></div>
                    <div class="col-md-8"><h2><spring:message code="welcome" /> ${utenteInDB.nomeCognome} <spring:message code="profiloUtente" /> ${utenteInDB.profilo}</h2></div>
                    <%--<div class="col-md-2"><button type="button" class="btn btn-default"><a href="logout.aspx">Logout</a></button></div>--%>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-default btn-lg">
                            <span class="glyphicon glyphicon-user">&nbsp;<a href="logout.do">Logout</a></span> 
                        </button>
                    </div>
                </div>
            </div>
            <div class="parteCentrale">
                <c:choose>
                    <c:when test="${utenteInDB.profilo eq 'admin'}">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="riepilogomese.do"><strong><spring:message code="riepilogo" /></strong></a></li>
                        </ul>
                    </c:when>
                    <c:when test="${utenteInDB.profilo eq 'normale'}">
                        <ul class="nav nav-tabs" role="tablist">
                            <li><a href="home.do"><strong>Home</strong></a></li>
                            <li><a href="listaprodotti.do"><strong><spring:message code="prodotti" /></strong></a></li>
                            <li><a href="#"><strong><spring:message code="ordini" /></strong></a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        // html prodotto se nessun test è verificato
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="col-md-5">
                <p class="text-info"><strong><spring:message code="valore" /> ${guadagno}</strong></p> 
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
