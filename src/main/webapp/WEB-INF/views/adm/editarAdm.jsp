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

		<div id="top" class="row">

			<form action="SalvarAdmEdicao" method="post">
				<!-- area de campos do form -->
				<div class="row">
					<div class="form-group col-md-4">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" id="nome" name="nome"value="${adm.nome}">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="senha">Senha</label> <input type="text"
							class="form-control" id="senha" name="senha" value="${adm.senha}">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="supermercado">Qual nome do mercado/supermercado que
							você representa?</label> <input type="text" class="form-control"
							id="supermercado" name="supermercado" value="${mer.supermercado}">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="supermercado">Endereço</label> <input type="text" class="form-control"
							id=""endereco"" name="endereco" value="${mer.endereco}">
					</div>
				</div>
				
				<div id="actions" class="row">
					<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
						<a href="home" class="btn btn-default">Home</a>
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