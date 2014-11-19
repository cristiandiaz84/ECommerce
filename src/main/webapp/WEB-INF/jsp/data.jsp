<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${prodotti}" var="prodotti">
    <table>
        <tr>
            <td>${prodotti.nome}</td>
        </tr>
    </table>
</c:forEach>
                                        
                                    