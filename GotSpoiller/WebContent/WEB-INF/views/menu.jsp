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
<meta charset="UTF-8">
</head>

<body>
<div class="main">

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<script><%@includefile="/resources/js/materialize.min.js"%></script>
	<script><%@includefile="/resources/js/menu.js"%></script>
	<nav>
	<div class="blue-grey darken-4 nav-wrapper">
		<a href="" class="blue-grey-text text-lighten-4 brand-logo center">GOT Spoiler</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="logout">Log Out</a></li>
		</ul>
	</div>
	</nav>
	<div class="row">
		<div class="col s2 m2 l2" id="">
			
		</div>
	</div>
	<div class="row">
		<div class="col s2 m2 l2">
			<div class="card">
				<div class="card-image waves-effect waves-block waves-light">
				<img class="circle responsive-img" src="getImage?login=${usuarioLogado}" />
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
					<p><img class="" src="https://www.freelogoservices.com/api/main/images/1j+ojl1FOMkX9WypfBe43D6kjfKArBVHkBvJwXs1M3EMoAJtlSAlhfpv9fsy" /></p>
				</div>
			</div>
		</div>
		<div class="col s8 m8 l8 blue-grey darken-1">
			
		<span class="blue-grey-text text-lighten-5" id = "description"><h4>Seja bem vindo ao Game of Thrones Spoiler Generator. Aqui você pode acabar com a vida de seus amigos com apenas um clique. Basta dizer até qual temporada
			 de Game of Thrones ele viu, que enviaremos um spoiller das tempordas seguintes. Use sem moderação.</h4>
			 <img class="logo"
							src="https://www.freelogoservices.com/api/main/images/1j+ojl1FOMkX9WypfBe43D6kjfKArBVHkBvJwXs1M3EMoAJtlSAlhfpv9fsy" />
			 </span>
				<div class="row">
					<div class="col s12">
						<div class="row">
							<div class="input-field col s6">
								<i class="material-icons prefix">account_circle</i> <input
									id="friendName" name="nome" type="text" class="validate"> <label
									for="icon_prefix">Nome do amigo</label>
							</div>
							<div class="input-field col s6">
								<i class="material-icons prefix">phone</i> <input
									id="friendPhone" name="numero" type="tel" class="validate"> <label
									for="icon_telephone">Número dele</label>
							</div>
						</div>
					</div>
				</div>



				<div class="input-field col s12">
					<select name="temp" id="temp">
						<option value="" disabled selected>Qual é a temporada que deseja mandar o spoiler? 	</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
					</select> <label>Temporada</label>	
				</div>
				
				<input type="text" name="login" value=${usuarioLogado} id="loginLabel">
				
				<div class="input-field col s12">
					<select name="spoiler" id="spoilers">
						<option value="" disabled selected>Qual spoiller deseja mandar?</option>
					</select> <label>Spoiller</label>
				</div>
			
				<div class="col s1 m6 l6">
				</div>
				
				<div class="col s2 m6 l6">
				<div id = "loader" class="preloader-wrapper big active">
					<div class="spinner-layer spinner-blue-only">
						<div class="circle-clipper left">
							<div class="circle"></div>
						</div>
						<div class="gap-patch">
							<div class="circle"></div>
						</div>
						<div class="circle-clipper right">
							<div class="circle"></div>
						</div>
					</div>
				</div>
			</div>

			<button class="right blue-grey darken-4 blue-grey-text text-lighten-4 btn waves-effect waves-light" id="sendButton" >Acabe com sua amizade :)<i class="material-icons right" >send</i>
			</button>
			
			<div class="row"></div>
			
		</div>
		
		<div class="col s2 m2 l2" id="history">
			<div class="center blue-grey darken-1 card-panel teal">
				<span class="white-text">Histórico de mensagens</span>
			</div>
		</div>
	</div>
	
	
</div>
</body>
</html>