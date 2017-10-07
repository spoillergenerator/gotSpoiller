<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<style media="screen,projection"><%@includefile="/resources/css/materialize.min.css"%></style>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script><%@includefile="/resources/js/materialize.min.js"%></script>
	<nav>
	<div class="brown darken-3 nav-wrapper">
		<a href="#" class="amber-text text-x	accent-4 brand-logo center">GOT Spoiller</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="logout">Log Out</a></li>
		</ul>
	</div>
	</nav>
	<div class="row">
		<div class="col s2 m2 l2">
			<div class="card">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="getImage?login=${usuarioLogado}" />
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">${usuarioLogado}<i class="material-icons right">more_vert</i>
					</span>
					<!--  <p>
						<a href="#">This is a link</a>
					</p>-->
				</div>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Bem vindo, ${usuarioLogado}<i class="material-icons right">close</i></span>
					<p>Here is some more information about this product that is
						only revealed once clicked on.</p>
				</div>
			</div>
		</div>
		<div class="col s8 m8 l8">
		<div class="brown card-panel teal">
			<span class="white-text"><h4>Seja bem vindo ao Got Spoiller Generator. Aqui você pode acabar com a vida de seus amigos com apenas um clique. Basta dizer até qual temporada
			 de Game of Thrones ele viu, que enviaremos um spoiller das tempordas seguintes. Use sem moderação.</h4></span>
		</div>
		</div>
	</div>
	
	
	
</body>
</html>