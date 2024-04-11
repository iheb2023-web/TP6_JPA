<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recherche des Sports</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="header.jsp" %>

	<div class="container">
		<h1>Recherche des Sports</h1>
		<form action="chercher.do" method="get">
			<div class="form-group">
				<label for="motCle">Mot Clé :</label> <input type="text" id="motCle"
					name="motCle" class="form-control" value="${model.motCle}" />
			</div>
			<button type="submit" class="btn btn-primary">Chercher</button>
		</form>
		<hr>
		<h2>Résultats de la recherche :</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nom Sport</th>
					<th>Description</th>
					<th>Date Fondation</th>
					<th>Genre</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${model.sp}" var="sport">
					<tr>
						<td>${sport.idSport}</td>
						<td>${sport.nomSport}</td>
						<td>${sport.description}</td>
						<td><fmt:formatDate value="${sport.dateFondation}"
								pattern='yyyy-MM-dd' /></td>
						<td>${sport.genre.nomGen}</td>
						<td>
							<div class="btn-group">
								<a href="editer.do?id=${sport.idSport}" class="btn btn-info">Editer</a>
								<a href="supprimer.do?id=${sport.idSport}" class="btn btn-danger" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce sport ?')">Supprimer</a>
							</div>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
