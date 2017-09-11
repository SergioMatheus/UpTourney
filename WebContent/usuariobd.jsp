<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<jsp:useBean id="eqp" class="br.uptourney.controller.UsuarioBdController" scope="session"/>

<title>Up Tourney - Seja um Gamer Profissional</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/heroic-features.css" rel="stylesheet">
<%@ include file="PP2.jsp"%>

</head>
<body>
			<div class="container">
			<div class="col-xs-5">
				
				<a href="usuarioBdController" class="btn btn-primary btn-large">Listar Equipes que participo</a>
			</div>
			</div>
				<div class="container"><br>
					<div class="col-xs-5">
				
				<a href="usuarioequipeliderController" class="btn btn-primary btn-large">Listar Equipes que sou lider</a>
			</div>
			</div>
			
			<div class="container"><br>
			<div class="col-xs-5">
			
				<a href="UsuarioMembrosEquipeController" class="btn btn-primary btn-large">Lista de membros da minha equipe</a>
			</div>
			</div>
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Site Feito em 2017</p>
				</div>
			</div>
		</footer>

</body>
</html>