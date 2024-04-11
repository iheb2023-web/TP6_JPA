
<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Modification des Sports</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des Sports</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div hidden class="form-group">
						<label class="control-label">ID Sport :</label> <input type="text"
							name="id" class="form-control" value="${sport.idSport}" />
					</div>
					<div class="form-group">
						<label class="control-label">Nom Sport :</label> <input
							type="text" name="nom" class="form-control"
							value="${sport.nomSport}" />
					</div>
					<div class="form-group">
						<label class="control-label">Description :</label> <input
							type="text" name="description" class="form-control"
							value="${sport.description}" />
					</div>
					<div class="form-group">
						<label class="control-label">Date Fondation :</label> <input
							type="text" name="date_fondation" class="form-control"
							value="<fmt:formatDate pattern='dd/MM/yyyy' value='${sport.dateFondation}' />" />
					</div>

					<div class="form-group">
						<select name="genre" class="form-control">
							<c:forEach items="${genres}" var="cat">
								<option value="${cat.idGen}">${cat.nomGen}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>
