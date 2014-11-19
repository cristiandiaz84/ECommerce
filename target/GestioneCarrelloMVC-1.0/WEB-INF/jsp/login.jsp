<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/toastr.css">
    </head>
    <body>
        <div class="container-fluid">
            <div clas="headr">
                <div class="row">
                    <div class="col-md-2"><img class="img-thumbnail logo" src="img/e-commerce.gif"></div>
                    <div class="col-md-7"><h3><spring:message code="welcome" /></h3></div>
                    <div class="col-md-3">
                        <a href="?language=it"><img src="${pageContext.request.contextPath}/img/it.jpg" /></a>
                        <a href="?language=en"> <img src="${pageContext.request.contextPath}/img/en.jpg" /></a>
                        <a href="?language=es"><img src="${pageContext.request.contextPath}/img/es.jpg" /></a> 
                        <a href="?language=de"><img src="${pageContext.request.contextPath}/img/de.jpg" /></a>
                        <a href="?language=fr"><img src="${pageContext.request.contextPath}/img/fr.jpg" /></a>
                        <a href="?language=ja_JP"><img src="${pageContext.request.contextPath}/img/jp.jpg" /></a><br />
                    </div>
                </div>
            </div>
            <div class="parteCentrale">
                <div class="row">
                    <form:form commandName="utente" action="login.do">

                        <div class="form-group col-md-4">
                            <label for="userName">Username: </label>
                            <form:input path="userName" id="userName" /><br/>
                            <form:errors path="userName" cssClass="error" /><br/>
                            <label for="password">Password: </label>
                            <form:password path="password" id="password" /><br/>
                            <form:errors path="password" cssClass="error" /><br/>
                            <input class="btn btn-default" type="submit" value="Login" onclick="return app.validaCampi();"/>
                            <a href="registrati.do"><img class="immagine" src="img/registarti.jpg"/></a>
                        </div>
                    </form:form>
                </div>
            </div>
            <%--inizio ajax con richiesta ascincrona e il risultato vienemesso nel div--%>
            <label for="prodotto"><spring:message code="prodotto" /></label>
            <input type="text" name="prodotto" onkeyup="mostraProdotti(this.value)" /><br/>
            <div id="parteajax"> </div>
            <%--fine parte ajax--%>
            <div class="row">
                <p class="text-danger col-md-6"><strong>${messaggio}</strong></p>
            </div>
            <div class="footer">
                <div class="col-md-12"><span class="glyphicon glyphicon-copyright-mark">Cristian Dionisio</span></div>
            </div>
        </div>          
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/toastr.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/ravioliprogram.js"></script>
    </body>

</html>