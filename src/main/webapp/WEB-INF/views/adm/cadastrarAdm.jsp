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
	<div id="main" class="container-fluid">
<div class="form-group">
			
				<div class="alert alert-info">
					<strong><h2>Cadastro</h2></strong><h3>${message}</h3>
				</div>
				
			</div>
	<hr />
		<div id="top" class="row">

			<form action="adicionarAdm" method="post">
				<!-- area de campos do form -->
				<div class="row">
					<div class="form-group col-md-4">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" id="nome" name="nome"value="${Adm.nome}">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="senha">Senha</label> <input type="text"
							class="form-control" id="senha" name="senha" value="${Adm.senha}">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="supermercado">Qual nome do mercado/supermercado que
							você representa?</label> <input type="text" class="form-control"
							id="supermercado" name="supermercado" value="${Mercado.supermercado}">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="supermercado">Endereço</label> <input type="text" class="form-control"
							id="endereco" name="endereco" value="${Mercado.endereco}">
					</div>
				</div>
				
				<div id="actions" class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-primary">Adicionar</button>
						<a href="home" class="btn btn-default">Voltar</a>
					</div>
				</div>
			</form>
	<hr />
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/bootbox.min.js"></script>
</body>
</html>