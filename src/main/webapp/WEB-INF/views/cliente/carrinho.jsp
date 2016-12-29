<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" />


</head>
<style>
</style>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">

		<div class="modal bs-example-modal-sm" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-body">
						<div class="row">Nome: ${cli.nome}</div>
						<div class="row">Senha: ${cli.senha}</div>

					</div>
					 <div class="modal-footer">
					<a href="BuscaContaCli?codigo=${cli.codigo}" class="btn btn-default btn-block">Editar Conta</a>					
						<a href="excluirContaCli?codigo=${cli.codigo}" class="btn btn-default btn-block">Excluir Conta</a>
					
					</div>
				</div>
			</div>
		</div>
		<div class="container" style="margin-top: 10px;">
			<ul class="nav nav-tabs">
				<li role="presentation"><a
					href="produtoslistarClientes?codigo=${cli.codigo}">Todos
						Produtos</a></li>
				<li role="presentation"><a href="mercados?codigo=${cli.codigo}">Busca
						por mercado</a></li>
				<li role="presentation"></li>
				<li role="presentation" class="active"><a href="#">Meu
						Carrinho</a></li>
				<li class="dropdown pull-right"><a href="#"
					data-toggle="dropdown"
					class="dropdown-toggle glyphicon glyphicon-user"><span>
							${cli.nome}</span> <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="home">Sair</a></li>
						</hr>
						<li class="divider"></li>
						<li><a class="btn btn-default" data-toggle="modal"
							data-target=".bs-example-modal-sm">Minha Conta</a></li>
					</ul></li>
			</ul>

		</div>
	</nav>
<body>
	<div class="container">
		<div class="row"></div>
		<hr>


		<c:if test="${not empty produtos}">
			<div id="list" class="row">

				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">

						<thead>
							<tr>
								<th>Descrição</th>
								<th>Preço</th>
								<th>Promoção</th>
								<th class="actions">#</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${produtos}" var="p">
								<tr>
									<td>${p.descricao}</td>
									<td>${p.preco}</td>
									<td>${p.promocao}</td>
									<td class="actions"><a class="btn btn-warning btn-xs"
										href="RemoverCarrinho?codigoCarrinho=${carrinho.codigoCarrinho}
								&&codigoCli=${cli.codigo}">Remover</a>

									</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
					<div class="row">
						<h1 class="text-right">
							<div class="alert alert-info ">
								<strong>Valor Total</strong> ${mercado.total}
							</div>
						</h1>
					</div>

				</div>
			</div>

		</c:if>

		<c:if test="${empty produtos}">
			<h4>
				<div class="alert alert-info">
					<strong>Info!</strong> Não há produtos!
				</div>
			</h4>
		</c:if>
	</div>
	<script type="text/javascript"
		src="<c:url value='/resources/js/jquery.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>

</body>
</html>
