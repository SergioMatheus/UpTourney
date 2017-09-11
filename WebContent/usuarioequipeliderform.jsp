<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Up Tourney - Seja um Gamer Profissional</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/heroic-features.css" rel="stylesheet">
<%@ include file="PP2.jsp"%>
<style type="text/css">
ul {
	list-style-type: none;	
}
</style>
</head>
<body>

	<form id="equipeform" method="post" class="form-horizontal" action="UsuarioEquipeLiderController">
				<c:forEach var="x" items="${listEquipeUsuario}">
								<ul>
								<li>Nome: <c:out value="${x.nomeEquipe}"></c:out><li>
								</ul>
					</c:forEach>
	</form>
	<hr>
	<div class="row">
		<div class="col-lg-12">
			<p>Copyright &copy; Site Feito em 2017</p>
		</div>
	</div>
</body>
</html>