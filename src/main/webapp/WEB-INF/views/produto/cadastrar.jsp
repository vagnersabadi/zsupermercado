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

	<div class="modal bs-example-modal-sm" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-body">
					<div class="row">
						Nome: ${adm.nome}
					</div>
					<div class="row">
						Senha: ${adm.senha}
					</div>
					<div class="row">
						Supermercado: ${mer.supermercado}
					</div>
					<div class="row">
						Endereço: ${mer.endereco}
					</div>
					</div>
					<div class="modal-footer">
					<a href="BuscaContaAdm?codigo=${adm.codigo}" class="btn btn-default btn-block">Editar Conta</a>					
						<a href="excluirContaAdm?codigo=${adm.codigo}" class="btn btn-default btn-block">Excluir Conta</a>
					
					</div>
				</div>
			</div>
		</div>
		<div class="container" style="margin-top: 10px;">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="listaProdutos?nome=${adm.nome}">Meus
						Produtos</a></li>
				<li role="presentation" class="active"><a href="#">Cadastro</a></li>
				<li role="presentation"><a href="produtoslistarPromocoes?nome=${adm.nome}">Minhas
						Promoções</a></li>
						<li class="dropdown pull-right">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle glyphicon glyphicon-user"><span> ${adm.nome}</span> <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="home">Sair</a></li>
                </hr>
                <li class="divider"></li>
                <li><a class="btn btn-default" data-toggle="modal"
			data-target=".bs-example-modal-sm">Minha Conta</a></li>
            </ul>
        </li>
        </ul>
		
		</div>
		</nav>
		<div class="row" style="margin-top: 20px;">
			<div class="col-md-1"></div>
			<div class="col-md-10">

				<form action="ProdutoInserir" method="post"
					style="margin-top: 30px;">

					<h1>
						<span class="fa fa-pencil"></span> Cadastrar Produto
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
					<div >
						<label for="promocao"> Promoção? </label> <select
							class="selectpicker" data-width="auto" name="promocao"
							id="promocao">
							<option value="Não">Não</option>
							<option value="Sim">Sim</option>
						</select>

					</div>
					<button type="submit" class="btn btn-success">OK</button>
				</form>
			</div>
			<div class="col-md-1"></div>
		</div>

	</div>
	<div class="col-md-1"></div>

	<script type="text/javascript"
			src="<c:url value='/resources/js/jquery.min.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>