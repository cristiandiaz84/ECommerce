<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
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
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="riepilogomese.do"><strong><spring:message code="riepilogo" /></strong></a></li>
                        </ul>
                    </c:when>
                    <c:when test="${utenteInDB.profilo eq 'normale'}">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="#"><strong>Home</strong></a></li>
                            <li><a href="listaprodotti.do"><strong><spring:message code="prodotti" /></strong></a></li>
                            <li><a href="listaordini.do"><strong><spring:message code="ordini" /></strong></a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        // html prodotto se nessun test è verificato
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="home col-md-2">
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="#"><spring:message code="chisiamo" /></a></li>
                    <li><spring:message code="contatti" /></li>
                </ul>
            </div>
            <div class="chisiamo col-md-10">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus interdum auctor. Aliquam lobortis lobortis euismod. Cras sodales aliquam maximus. Proin in dapibus elit. Donec tristique metus nec tortor semper dictum. Vivamus lobortis sodales sapien, vel ultrices urna aliquam ac. Vestibulum at lobortis ipsum.

                Pellentesque sed nisl euismod, accumsan felis ac, convallis mauris. Mauris convallis metus in ligula tincidunt facilisis. Aliquam et vulputate libero, quis accumsan lorem. Ut elit metus, maximus sit amet venenatis eget, consequat id neque. Integer euismod dolor id lorem tempor, vitae sagittis lorem luctus. Morbi nec congue ante. Mauris odio enim, egestas vitae rhoncus vel, porttitor vitae nulla. Sed in malesuada lorem.

                Nam vitae quam pulvinar, eleifend ante eu, pretium ipsum. Suspendisse venenatis quis metus sit amet iaculis. Pellentesque ligula sapien, volutpat id imperdiet id, suscipit hendrerit nisl. In in mauris tempor quam faucibus mollis vitae eu augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed diam neque, dignissim et volutpat eget, feugiat sit amet velit. Donec eget dapibus arcu.

                Integer tincidunt elit fermentum dapibus venenatis. Pellentesque gravida mollis dolor, et dapibus odio bibendum in. Sed et neque id ligula ultrices semper vitae eget nunc. Morbi laoreet, tellus vitae condimentum porta, felis dui molestie elit, non facilisis nisl lorem in erat. Pellentesque tortor elit, egestas quis sollicitudin sed, tristique quis dolor. Fusce id dui mauris. Suspendisse bibendum felis dolor, at elementum metus ornare eget. Mauris facilisis dapibus erat, quis rutrum felis consequat vel.

                Donec convallis dui mi, non gravida sapien interdum vitae. Aenean est felis, porta sit amet sagittis a, rutrum vel arcu. Nulla rutrum turpis neque, ut vulputate erat mattis at. Quisque diam felis, facilisis at molestie eu, accumsan sed libero. Nam facilisis sapien sapien, et consequat sem congue ac. Etiam ornare leo maximus sollicitudin vulputate. Curabitur sagittis libero ut risus gravida consequat.
            </div>
            <div class="contatti col-md-10">
                <address>
                    <strong>Twitter, Inc.</strong><br>
                    795 Folsom Ave, Suite 600<br>
                    San Francisco, CA 94107<br>
                    <abbr title="Phone">P:</abbr> (123) 456-7890
                </address>

                <address>
                    <strong>Full Name</strong><br>
                    <a href="mailto:#">first.last@example.com</a>
                </address>
            </div>

        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
