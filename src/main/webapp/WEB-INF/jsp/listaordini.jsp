<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                            <li><a href="riepilogomese.do"><strong><spring:message code="riepilogo" /></strong></a></li>
                        </ul>
                    </c:when>
                    <c:when test="${utenteInDB.profilo eq 'normale'}">
                        <ul class="nav nav-tabs" role="tablist">
                            <li><a href="home.do"><strong>Home</strong></a></li>
                            <li><a href="listaprodotti.do"><strong><spring:message code="prodotti" /></strong></a></li>
                            <li class="active"><a href="#"><strong><spring:message code="ordini" /></strong></a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        // html prodotto se nessun test è verificato
                    </c:otherwise>
                </c:choose>
            </div>
            <h3><spring:message code="ordiniintestazione1" /> ${utenteInDB.nomeCognome} <spring:message code="ordiniintestazione2" /></h3>
            <div class="col-md-5">
                <c:choose>
                    <c:when test="${ordini.size()>0}">
                        <table class="table table-bordered table-condensed table-striped">
                            <thead>
                                <tr>
                                    <th><spring:message code="giorno" /></th>
                                    <th><spring:message code="prodottihead.prezzoT" /></th>
                                    <th><spring:message code="prodottihead.eliminaO" /></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ordini}" var="ordini">
                                    <tr>
                                        <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ordini.dataOrdine}"  /></td>
                                        <td>${ordini.prezzoTot}</td>
                                        <td>
                                            <a href="eliminaOrdine.do?idOrdine=${ordini.idOrdine}"><span class="glyphicon glyphicon-trash"></span></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p class="text-info"><strong>Non ci sono ordini presenti</strong></p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
        
       
            

