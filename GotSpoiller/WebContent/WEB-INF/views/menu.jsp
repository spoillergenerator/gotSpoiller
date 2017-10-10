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
<style><%@includefile="/resources/css/menu.css"%></style>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script><%@includefile="/resources/js/materialize.min.js"%></script>
	<script><%@includefile="/resources/js/menu.js"%></script>
	
	<nav>
	<div class="blue-grey darken-4 nav-wrapper">
		<a href="#" class="blue-grey-text text-lighten-4 brand-logo center">GOT Spoiller</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="logout">Log Out</a></li>
		</ul>
	</div>
	</nav>
	<div class="row"></div>
	<div class="row">
		<div class="col s2 m2 l2">
			<div class="card">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="getImage?login=${usuarioLogado}" />
				</div>
				<div class="blue-grey darken-1 card-content">
					<span class="card-title activator blue-grey-text text-lighten-5">${usuarioLogado}<i class="material-icons right">more_vert</i>
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
		<div class="col s8 m8 l8 blue-grey darken-1">
		<span class="blue-grey-text text-lighten-5"><h4>Seja bem vindo ao Got Spoiller Generator. Aqui você pode acabar com a vida de seus amigos com apenas um clique. Basta dizer até qual temporada
			 de Game of Thrones ele viu, que enviaremos um spoiller das tempordas seguintes. Use sem moderação.</h4></span>
				<div class="row">
					<form class="col s12">
						<div class="row">
							<div class="input-field col s6">
								<i class="material-icons prefix">account_circle</i> <input
									id="icon_prefix" type="text" class="validate"> <label
									for="icon_prefix">Nome do amiguinho que vai se fuder</label>
							</div>
							<div class="input-field col s6">
								<i class="material-icons prefix">phone</i> <input
									id="icon_telephone" type="tel" class="validate"> <label
									for="icon_telephone">numero dele</label>
							</div>
						</div>
					</form>
				</div>



				<div class="input-field col s12">
					<select>
						<option value="" disabled selected>Qual é proxima temporada dele?</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="3">4</option>
						<option value="3">5</option>
						<option value="3">6</option>
						<option value="3">7</option>
					</select> <label>Temporada</label>
				</div>
			<form action="mandar">
			<button class="right blue-grey darken-4 blue-grey-text text-lighten-4 btn waves-effect waves-light" type="submit"
				name="action">Acabe com sua amizade :)<i class="material-icons right">send</i>
			</button>
			</form>
			<div class="row"></div>
		</div>
	</div>
	
	
	
</body>
</html>