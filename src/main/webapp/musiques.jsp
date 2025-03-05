<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Musiques</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="container">
        <div class="card">
            <div class="card-header">Liste des Musiques</div>
            <div class="card-body">
                <form action="chercher.do" method="get">
                    <input type="text" name="motCle" value="${motCle}" />
                    <button type="submit" class="btn btn-primary">Chercher</button>
                </form>
                <table class="table table-striped">
                    <tr>
                        <th>ID</th><th>Titre</th><th>Durée</th><th>Actions</th>
                    </tr>
                    <c:forEach items="${model.musiques}" var="m">
                        <tr>
                            <td>${m.idMusique}</td>
                            <td>${m.titre}</td>
                            <td>${m.duree}</td>
                            <td>
                                <a href="editer.do?id=${m.idMusique}">Modifier</a> |
                                <a href="supprimer.do?id=${m.idMusique}" onclick="return confirm('Êtes-vous sûr ?')">Supprimer</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>