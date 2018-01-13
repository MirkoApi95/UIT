<%@page import="java.util.ArrayList"%>
<%@page import="entity.ProgettoFormativo"%>
<%@page import="entity.Tirocinante"%>
<%@page import="entity.TutorAziendale"%>
<%@page import="entity.TutorUniversitario"%>
<%@page import="entity.Utente"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="utente" class="entity.Utente" scope="session"></jsp:useBean>
<jsp:useBean id="tutorAziendale" class="entity.TutorAziendale" scope="session"></jsp:useBean>

	

<html lang="en" class="mediaqueries matchmedia mediaqueries matchmedia">
<head>
<title>UIT Home</title>

<meta charset="utf-8">
<!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="">

<!-- Google Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Montserrat:400,700%7CSource+Sans+Pro:400,300,700,600%7CPlayfair+Display:400,700,400italic"
	rel="stylesheet">

<!-- Css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-icons.css">
<link rel="stylesheet" href="revolution/css/settings.css">
<link rel="stylesheet" href="css/rev-slider.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/colors/color-mint.css">

<!-- Favicons -->
<link rel="shortcut icon" href="img/world.png">
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="img/apple-touch-icon-114x114.png">

</head>

<body>

	<!-- Preloader -->
	<div class="loader-mask" style="display: none;">
		<div class="loader" style="display: none;">
			<div></div>
			<div></div>
		</div>
	</div>

	<!-- Navigation -->
	<header class="nav">

		<div class="nav__holder nav--sticky">
			<div class="container relative">
				<div class="flex-parent">

					<form method="get" class="nav__search-wrap">
						<input type="search" class="nav__search-input"
							placeholder="Type &amp; Hit Enter"> <i
							class="fa fa-close nav__search-close" id="nav__search-close"></i>
					</form>

					<div class="nav__header clearfix">
						<!-- Logo -->
						<div class="logo-wrap">
							<a href="index.html" class="logo__link"> <img
								class="logo logo--dark" src="img/logo2.png" alt="logo">
							</a>
						</div>
						<button type="button" class="nav__icon-toggle"
							id="nav__icon-toggle" data-toggle="collapse"
							data-target="#navbar-collapse" aria-expanded="true">
							<span class="sr-only">Toggle navigation</span> <span
								class="nav__icon-toggle-bar"></span> <span
								class="nav__icon-toggle-bar"></span> <span
								class="nav__icon-toggle-bar"></span>
						</button>
					</div>
					<!-- end nav-header -->
					<nav id="navbar-collapse"
						class="nav__wrap navbar-collapse collapse in" aria-expanded="true"
						style="">
						<ul class="nav__menu">
						</ul>
						<!-- end menu -->

					</nav>
					<!-- end nav-wrap -->

				</div>
				<!-- end flex-parent -->
			</div>
			<!-- end container -->

		</div>
	</header>
	<!-- end navigation -->

	<div class="container">
		<div class="row">
			<form class="form-horizontal" action="ProgettoFormativoServlet" method="post">
				<fieldset>
					<!-- Form Name -->
					<legend> Progetto Formativo e di Orientamento</legend>
					<!-- Text input-->
					<%Utente utentet=(Utente)request.getAttribute("datiUtenteTirocinante");%>
					<div class="form-group">
						<label class="col-md-4 control-label" for="Name">Nome</label>
						<div class="col-md-5">
							<input id="Name" name="Name" type="text" value="<%=utentet.getNome() %>"
								class="form-control input-md" readonly>

						</div>
					</div>

					<!-- Cognome input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="passwordinput">Cognome</label>
						<div class="col-md-5">
							<input id="surnameinput" name="surnameinput" type="text" value="<%=utentet.getCognome() %>"
								class="form-control input-md" readonly>
						</div>
					</div>

					<!-- Address input-->
					<%Tirocinante tirocinante=(Tirocinante)request.getAttribute("datiTirocinante");%>
					<div class="form-group">
						<label class="col-md-4 control-label" for="address">Matricola</label>
						<div class="col-md-5">
							<input id="matricola" name="matricola" type="text" value="<%=tirocinante.getMatricola() %>"
								class="form-control input-md" readonly>
						</div>
					</div>

					<!-- Textarea -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="address">CFU
							Acquisiti</label>
						<div class="col-md-4 col-lg-5">
							<input type="text" value="<%=tirocinante.getNumeroCfu() %>" class="form-control" id="cfu" name="cfu" readonly>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="emailId">Anno
							Iscrizione</label>
						<div class="col-md-5 col-lg-5">
							<input id="annoiscr" name="annoiscr" type="text" value="<%=tirocinante.getAnno()%>"
								class="form-control input-md" readonly >
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="emailId">Anno
							in corso</label>
						<div class="col-md-5 col-lg-5">
							<input id="annocorso" name="annocorso" type="text" value="2018"
								class="form-control input-md" readonly>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="azienda">Azienda/Ente
							Ospitante</label>
						<div class="col-md-5 col-lg-5">
						<%TutorAziendale ta=(TutorAziendale)request.getAttribute("datiAzienda");%>

							<input id="azienda" name="azienda" type="text" value="<%=ta.getNomeazienda()%>"
								class="form-control input-md" readonly>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Tutor Accademico">Tutor
							Accademico</label>
						<div class="col-md-5 col-lg-5">
						<%Utente tu=(Utente)request.getAttribute("datiUtenteTirocinante");%>
							<input id="tutoraccademico" name="tutoraccademico" type="text" value="<%=utente.getCognome() +" "+ utente.getNome()%>"
								class="form-control input-md" readonly>
						</div>
					</div>

					<!-- Textarea -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="address">Obiettivi
							e finalita' </label>
						<div class="col-md-4 col-lg-5">
						<%ProgettoFormativo pj=(ProgettoFormativo)request.getAttribute("progetto");%>
							<input class="form-control" id="obiettivi" name="obiettivi" value="<%= pj.getObiettivi() %>" readonly>
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="address"> Convalida Direttore Dipartimento </label>
						<div class="col-md-4 col-lg-5">
							<% if (pj.getConvalidaDd()==true) {%>
								<span> La pratica è stata accettata </span>
								<img alt="ConvalidaDDAccettata" src="img/verde.png" style="float:right">
								<%}  else{%>
								<span> La pratica non è ancora stata accettata </span>
								<img alt="ConvalidaDDNonAccettata" src="img/arancio.png" style="float:right">
							
								<%} %>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label" for="address"> Convalida Tutor Universitario </label>
						<div class="col-md-4 col-lg-5">
							<% if (pj.getConvalidaTu()==true) {%>
								<span>La pratica è stata accettata </span>
								<img alt="ConvalidaTUAccettata" src="img/verde.png" style="float:right">
								<%} else{%>
								<span> La pratica non è ancora stata accettata </span>
								<img alt="ConvalidaTUNonAccettata" src="img/arancio.png" style="float:right">
						<%} %>
						</div>
					</div>
				</fieldset>
			</form>
			
			<!-- form per convalida di TU -->
			<form class="form-horizontal" action="" method="">
				<button id="submit" name="submit" class="btn btn-success">Convalida</button>
			</form>
			
			<!-- form per convalida di TA -->
			<form class="form-horizontal" action="" method="">
				<button id="submit" name="submit" class="btn btn-success">Convalida</button>
			</form>
			
		</div>
	</div>

	<footer class="footer">


		<div class="footer-bottom">
			<div class="container">
				<div class="row">

					<div class="col-sm-6 col-xs-12">
						<span class="copyright"> Made by UIT Team </span>
					</div>

					<div class="col-sm-4 col-sm-offset-2 col-xs-12 clearfix">
						<div
							class="socials socials--nobase footer__socials clearfix right">
							<a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-google-plus"></i></a> <a href="#"><i
								class="fa fa-linkedin"></i></a> <a href="#"><i
								class="fa fa-vimeo"></i></a> <a href="#"><i
								class="fa fa-instagram"></i></a>
						</div>
					</div>

				</div>
			</div>
		</div>
		<!-- end bottom footer -->
	</footer>
	<!-- end footer -->

	<div id="back-to-top" class="">
		<a href="#top"><i class="fa fa-angle-up"></i></a>
	</div>
	<!-- jQuery Scripts -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/plugins.js"></script>
	<script type="text/javascript"
		src="revolution/js/jquery.themepunch.tools.min.js"></script>
	<script type="text/javascript"
		src="revolution/js/jquery.themepunch.revolution.min.js"></script>
	<script type="text/javascript" src="js/rev-slider.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>

	<!-- Rev Slider Offline Scripts -->
	<script type="text/javascript"
		src="revolution/js/extensions/revolution.extension.video.min.js"></script>
	<script type="text/javascript"
		src="revolution/js/extensions/revolution.extension.carousel.min.js"></script>
	<script type="text/javascript"
		src="revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
	<script type="text/javascript"
		src="revolution/js/extensions/revolution.extension.actions.min.js"></script>
	<script type="text/javascript"
		src="revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
	<script type="text/javascript"
		src="revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
	<script type="text/javascript"
		src="revolution/js/extensions/revolution.extension.navigation.min.js"></script>
	<script type="text/javascript"
		src="revolution/js/extensions/revolution.extension.migration.min.js"></script>
	<script type="text/javascript"
		src="revolution/js/extensions/revolution.extension.parallax.min.js"></script>
</body>
</html>