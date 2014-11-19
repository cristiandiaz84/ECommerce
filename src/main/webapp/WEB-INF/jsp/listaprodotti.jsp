<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html">

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
                            <li><a href="riepilogomese.do"><strong><spring:message code="riepilogo" /></strong></a></li>
                        </ul>
                    </c:when>
                    <c:when test="${utenteInDB.profilo eq 'normale'}">
                        <ul class="nav nav-tabs" role="tablist">
                            <li><a href="home.do"><strong>Home</strong></a></li>
                            <li class="active"><a href="#"><strong><spring:message code="prodotti" /></strong></a></li>
                            <li><a href="listaordini.do"><strong><spring:message code="ordini" /></strong></a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        // html prodotto se nessun test è verificato
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="col-md-5">
                <c:choose>
                    <c:when test="${prodotti.size() > 0}">
                        <h2><spring:message code="prodottititle" /></h2>
                        <table class="table table-bordered table-striped table-condensed">
                            <thead>
                                <tr>
                                    <th><spring:message code="prodottihead.nome" /></th>
                                    <th><spring:message code="prodottihead.descrizione" /></th>
                                    <th><spring:message code="prodottihead.prezzo" /></th>
                                    <th><spring:message code="prodottihead.aggiungi" /></th>  
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${prodotti}" var="prodotti">
                                    <tr>
                                        <td>${prodotti.nome}</td>
                                        <td>${prodotti.descrizione}</td>
                                        <td>${prodotti.prezzo}</td>
                                        <td>
                                            <a href="aggiungiacarrello.do?idProdotto=${prodotti.idProdotto}">
                                                <img src="img/cart.jpg" />
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p class="text-info"><spring:message code="noprodotti" /></p>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="col-md-7">
                <c:choose>
                    <c:when test="${carrello.size() > 0}">
                        <h2><spring:message code="carrellotitle" /></h2>
                        <table class="table table-bordered table-striped table-condensed">
                            <thead>
                                <tr>
                                    <th><spring:message code="prodottihead.nome" /></th>
                                    <th><spring:message code="prodottihead.descrizione" />o</th>
                                    <th><spring:message code="prodottihead.prezzoU" /></th>
                                    <th><spring:message code="prodottihead.quantita" /></th>
                                    <th><spring:message code="prodottihead.prezzoT" /></th>
                                    <th><spring:message code="prodottihead.elimina" /></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${carrello.vociCarrello}" var="voce">
                                    <tr>
                                        <td>${voce.prodotto.nome}</td>
                                        <td>${voce.prodotto.descrizione}</td>
                                        <td>${voce.prodotto.prezzo}</td>
                                        <td>${voce.quantita}</td>
                                        <td>${voce.calcolaCosto()}</td>
                                        <td><a href="eliminaVoce.do?idProdotto=${voce.prodotto.idProdotto}">
                                                <img src="img/delete.png" />
                                            </a>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="acquista">
                            <b><spring:message code="costocarrello" /> ${carrello.calcolaCosto()}</b>
                            <a href="acquista.do">
                                <img src="img/checkout.jpg" />
                            </a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p class="text-info"><strong><spring:message code="nocarrello" /></strong></p>
                    </c:otherwise>
                </c:choose>
                    <p class="text-success"><strong>${messaggio}</strong></p>
            </div>
        </div>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
    </body>
</html>
