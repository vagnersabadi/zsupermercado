<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" />


</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">

	<div class="modal bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-body">
					<div class="row">Nome: ${adm.nome}</div>
					<div class="row">Senha: ${adm.senha}</div>
					<div class="row">Supermercado: ${mer.supermercado}</div>
					<div class="row">Endereço: ${mer.endereco}</div>
				</div>
				<div class="modal-footer">
					<a href="BuscaContaAdm?codigo=${adm.codigo}"
						class="btn btn-default btn-block">Editar Conta</a> <a
						href="excluirContaAdm?codigo=${adm.codigo}"
						class="btn btn-default btn-block">Excluir Conta</a>

				</div>
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 10px;">
		<ul class="nav nav-tabs">

			<li role="presentation" class="active"><a href="#">Todos
					Produtos</a></li>
			<li role="presentation"><a
				href="produtoscadastrar?codigo=${adm.codigo}&&codigoNome=${adm.nome}">Cadastro</a></li>
			<li role="presentation"><a
				href="produtoslistarPromocoes?codigo=${adm.codigo}">Minhas
					promoções</a></li>


			<li class="dropdown pull-right"><a href="#"
				data-toggle="dropdown"
				class="dropdown-toggle glyphicon glyphicon-user"><span>
						${adm.nome}</span> <b class="caret"></b></a>
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
	<c:if test="${not empty produtos}">

		<div id="list" class="row">

			<div class="table-responsive col-md-12">
				<table class="table table-striped" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th>Codigo</th>
							<th>Descrição</th>
							<th>Preço</th>
							<th>Promoção</th>
							<th class="actions">#</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${produtos}" var="c">
							<tr>
								<td>${c.codigo}</td>
								<td>${c.descricao}</td>
								<td>${c.preco}</td>
								<td>${c.promocao}</td>
								<td><a class="btn btn-success fa fa-wrench "
									href="BuscarProduto?codigo=${c.codigo}" title="Alterar Produto">Editar
								</a> <a class="btn btn-danger fa fa-remove"
									href="ExcluirProduto?codigo=${c.codigo}"
									title="Deletar Produto">Deletar </a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>
		</div>
		<!--/#list -->
	</c:if>
	<c:if test="${empty produtos}">
		<h1>
			<div class="alert alert-info">
				<strong>Info!</strong> Não há Produtos
			</div>
		</h1>
	</c:if>


	<script type="text/javascript"
		src="<c:url value='/resources/js/jquery.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>