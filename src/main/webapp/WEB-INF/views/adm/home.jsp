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
<nav class="navbar navbar-default navbar-fixed-top">

	<div class="container" style="margin-top: 10px;">
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a href="#">Home</a></li>
			<li role="presentation"><a href="produtoscadastrar">Cadastro</a></li>
			<li role="presentation"><a href="listaProdutos">Meus
					Produtos</a></li>
			<li role="presentation"><a href="produtoslistarPromocoes">Minhas
					Promoções</a></li>
		</ul>
</nav>
		<div class="row" style="margin-top: 50px;">
			<div class="col-lg-12 text-center">
				<h1>ZSuper-Seu sistema de Controle</h1>
			</div>
		</div>

		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<img id="logo" class="img img-responsive center-block"
					src="http://blog.locaweb.com.br/wp-content/uploads/2012/07/ecommerce.jpg">
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/bootbox.min.js"></script>
</body>
</html>