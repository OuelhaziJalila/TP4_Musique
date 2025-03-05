<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Modifier une Musique</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="container">
        <div class="card">
            <div class="card-header">Modifier une Musique</div>
            <div class="card-body">
                <form action="update.do" method="post">
                    <div class="form-group">
                        <label>ID :</label>
                        <input type="text" readonly name="id" class="form-control" value="${musique.idMusique}"  />
                    </div>
                    <div class="form-group">
                        <label>Titre :</label>
                        <input type="text" name="titre" class="form-control" value="${musique.titre}"  />
                    </div>
                    <div class="form-group">
                        <label>Durée :</label>
                        <input type="text" name="duree" class="form-control" value="${musique.duree}"  />
                    </div>
                    <button type="submit" class="btn btn-primary">Modifier</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>