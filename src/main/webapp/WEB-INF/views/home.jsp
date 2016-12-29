<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>


<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" />


</head>
<body>
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-body">
				<i class="fa fa-question-circle"></i>Oque você é?
			</div>
			<div class="modal-footer">
				<a href="loginClientes" class="btn btn-primary btn-block">Sou
					Cliente</a>
			</div>
			<div class="modal-footer">
				<a href="login" class="btn btn-primary btn-block">Sou
					Comerciante</a>
			</div>
		</div>
	</div>

</body>
</html>
