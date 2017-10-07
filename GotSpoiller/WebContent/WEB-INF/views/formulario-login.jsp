<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login/Sign-In</title>

<!--<spring:url value="/resources/style.css" var="mainCss"/>
<link href="${mainCss}" rel="stylesheet"/>-->


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>


<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  
<style><%@includefile="/resources/css/style.css"%></style>
<script><%@includefile="/resources/js/index.js"%></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
	<!--<h2>Página de Login</h2>
	<form action="efetuaLogin" method="post">
		Login: <input type="text" name="login" /> <br /> 
		Senha: <input type="password" name="senha" /> <br /> 
		<input type="submit" value="Entrar nas tarefas" />
	</form>-->


<body>
	<div class="logmod">
    <div class="logmod__wrapper">
      <span class="logmod__close">Close</span>
      <div class="logmod__container">
        <ul class="logmod__tabs">
          <li data-tabtar="lgm-2"><a href="#">Login</a></li>
          <li data-tabtar="lgm-1"><a href="#">Sign Up</a></li>
        </ul>
        <div class="logmod__tab-wrapper">
          <div class="logmod__tab lgm-1">
            <div class="logmod__heading">
              <span class="logmod__heading-subtitle">Enter your personal details <strong>to create an acount</strong></span>
            </div>
            <div class="logmod__form">

              <!-- <form action="efetuaRegistro" method="post" enctype="multipart/form-data">
                Login: <input type="text" name="login" /> <br /> 
                Senha: <input type="password" name="senha" /> <br /> 
                Foto:<input type="file" name="foto" /> <br /> 
                <input type="submit" value="Registrar" />
              </form> -->

              <form accept-charset="utf-8" action="efetuaRegistro"
								class="simform" method="post" enctype="multipart/form-data">
                <div class="sminputs">
                  <div class="input full">
                    <label class="string optional" for="user-name">Email*</label>
                    <input class="string optional" maxlength="255"
											id="user-email" placeholder="Email" size="50"
											name="login" //>
                  </div>
                </div>
                <div class="sminputs">
                  <div class="input string optional">
                    <label class="string optional" for="user-pw">Password *</label>
                    <input class="string optional" maxlength="255"
											id="user-pw" placeholder="Password" type="text" size="50"
											name="senha" />
                  </div>
                  <div class="input string optional">
                    <label class="string optional" for="user-pw-repeat">Repeat password *</label>
                    <input class="string optional" maxlength="255"
											id="user-pw-repeat" placeholder="Repeat password" type="text"
											size="50" />
                  </div>
                </div>
                <div class="simform__actions">
                  Foto de perfil: <input type="file" name="foto" /> <br />
                  <input class="sumbit" name="commit" type="submit"
										value="Create Account" />
                  <span class="simform__actions-sidetext">By creating an account you agree to our <a
										class="special" href="#" target="_blank" role="link">Terms & Privacy</a></span>
                </div>
              </form>
            </div>
            <div class="logmod__alter">
              <div class="logmod__alter-container">
                <a href="#" class="connect facebook">
                  <div class="connect__icon">
                    <i class="fa fa-facebook"></i>
                  </div>
                  <div class="connect__context">
                    <span>Create an account with <strong>Facebook</strong></span>
                  </div>
                </a>

              </div>
            </div>
          </div>
          <div class="logmod__tab lgm-2">
            <div class="logmod__heading">
              <span class="logmod__heading-subtitle">Enter your email and password <strong>to sign in</strong></span>
            </div>
            <div class="logmod__form">
              <!-- <form action="efetuaLogin" method="post">
                    Login: <input type="text" name="login" /> <br /> 
                    Senha: <input type="password" name="senha" /> <br /> 
                    <input type="submit" value="Entrar nas tarefas" />
                  </form> -->
              <form accept-charset="utf-8" action="efetuaLogin"
								method="post" class="simform">
                <div class="sminputs">
                  <div class="input full">
                    <label class="string optional" for="user-name">Email*</label>
                    <input class="string optional" maxlength="255"
											id="user-email" placeholder="Email" size="50"
											name="login" />
                  </div>
                </div>
                <div class="sminputs">
                  <div class="input full">
                    <label class="string optional" for="user-pw">Password *</label>
                    <input class="string optional" maxlength="255"
											id="user-pw" placeholder="Password" type="password" size="50"
											name="senha" />
                    <span class="hide-password">Show</span>
                  </div>
                </div>
                <div class="simform__actions">
                  <input class="sumbit" name="commit" type="submit"
										value="Log In" />
                  <span class="simform__actions-sidetext"><a
										class="special" role="link" href="#">Forgot your password?<br>Click here</a></span>
                </div>
              </form>
            </div>
            <div class="logmod__alter">
              <div class="logmod__alter-container">
                <a href="#" class="connect facebook">
                  <div class="connect__icon">
                    <i class="fa fa-facebook"></i>
                  </div>
                  <div class="connect__context">
                    <span>Sign in with <strong>Facebook</strong></span>
                  </div>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
</html>