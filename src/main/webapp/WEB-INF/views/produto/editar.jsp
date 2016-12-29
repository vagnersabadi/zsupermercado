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
	<div class="container" style="margin-top: 10px;">

		<div class="modal bs-example-modal-sm" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-body">
					<div class="row">
						Nome:<input type="hidden" value="${adm.nome}">
					</div>
					<div class="row">
						Senha:<input type="hidden" value="${adm.senha}">
					</div>
					<div class="row">
						Supermercado:<input type="hidden" value="${mer.supermercado}">
					</div>
					<div class="row">
						Endereço:<input type="hidden" value="${mer.endereco}">
					</div>
					</div>
					<div class="modal-footer">
					<a href="BuscaContaAdm?codigo=${adm.codigo}" class="btn btn-default btn-block">Editar Conta</a>					
						<a href="excluirContaAdm?codigo=${adm.codigo}" class="btn btn-default btn-block">Excluir Conta</a>
					
					</div>
				</div>
			</div>
		</div>

		<div class="row" style="margin-top: 20px;">
			<div class="col-md-1"></div>
			<div class="col-md-10">

				<form action="ProdutoEditado?codigo=${p.codigo}" method="post"
					style="margin-top: 30px;">

					<h1>
						<span class="fa fa-pencil"></span> Editar Produto
					</h1>

					<div class="form-group">
						<label for="descricao"> Descrição </label> <input type="text"
							class="form-control" id="descricao" name="descricao"
							placeholder="Descrição" value="${p.descricao}">
					</div>

					<div class="form-group">
						<label for="preco"> Preço </label> <input type="text"
							class="form-control" id="preco" name="preco" placeholder="Preço"
							value="${p.preco}">
					</div>
					<div class="form-group">
						<label for="promocao"> Promoção? </label> <select
							class="selectpicker" data-width="auto" name="promocao"
							id="promocao">
							<option value="Sim">Sim</option>
							<option value="Não">Não</option>
						</select>

					</div>
					<button type="submit" class="btn btn-success">Salvar</button>
					<a href="listaProdutos" class="btn btn-primary ">Cancelar</a>
				</form>
			</div>
			<div class="col-md-1"></div>
		</div>

	</div>
	<div class="col-md-1"></div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>