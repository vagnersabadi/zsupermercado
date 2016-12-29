<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" />


</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">


		<div class="container" style="margin-top: 10px;">
			<ul class="nav nav-tabs">

				<li role="presentation"><a href="produtoslistarClientes?codigo=${cli.codigo}">Todos Produtos</a></li>
				<li role="presentation" class="active"><a href="#">Busca por
						mercado</a></li>
				<li role="presentation">
				<li role="presentation"></li>
						<li role="presentation" ><a href="MeuCarrinho?codigo=${cli.codigo}">Meu Carrinho</a></li>
			</ul>
		</div>
		</nav>
		<div class="container" style="margin-top: 10px;">
				<form action="PesquisarMercado?codigo=${cli.codigo}" method="post"
					style="margin-top: 30px;">
					
				<select class="selectpicker" name="IdMercado">
				<c:forEach var="a" items="${mercados}">
							<option value="${a.codigo}">${a.supermercado}</option>
				</c:forEach>
				
				</select>
				<button type="submit" class="btn btn-success">Pesquisar</button>
				
				</form>				
				
				</div>

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
							<c:forEach items="${produtos}" var="c">
								<tr>
									<td>${c.descricao}</td>
									<td>${c.preco}</td>
									<td>${c.promocao}</td>
									<td><a class="btn btn-warning btn-xs" href="AdicionarCarrinho?codigo=${c.codigo}
									&&codigoCli=${cli.codigo}">Adicionar ao Carrinho</a> 
								</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>
			<!--/#list -->
		</c:if>
		<c:if test="${empty produtos}">
			<div class="form-group">
			
				<div class="alert alert-info">
					<strong>Info!</strong>Escolha seu mercado
				</div>
				
			</div>
			
		</c:if>


		<script type="text/javascript"
			src="<c:url value='/resources/js/jquery.min.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>