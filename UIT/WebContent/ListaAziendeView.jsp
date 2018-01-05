<%@page import="java.util.ArrayList"%>
<%@page import="entity.TutorAziendale"%>
<%@page import="entity.TutorUniversitario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="tutoraziendale" class="entity.TutorAziendale"
	scope="session"></jsp:useBean>
<!DOCTYPE html>
<html lang="en" class="mediaqueries matchmedia">
<head>
<title>Lista delle Aziende</title>

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
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style_table.css">
<link rel="stylesheet" href="css/colors/color-mint.css">

<!-- Favicons -->
<link rel="shortcut icon" href="img/world.png">
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="img/apple-touch-icon-114x114.png">

<script type="text/javascript" charset="UTF-8"
	src="http://maps.google.com/maps-api-v3/api/js/31/3/intl/it_ALL/common.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="http://maps.google.com/maps-api-v3/api/js/31/3/intl/it_ALL/util.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="http://maps.google.com/maps-api-v3/api/js/31/3/intl/it_ALL/stats.js"></script>
</head>


<%
	ArrayList<TutorAziendale> lista = new ArrayList<TutorAziendale>();
	lista = (ArrayList<TutorAziendale>) request.getAttribute("array");
%>

<%
	ArrayList<TutorUniversitario> list=new ArrayList<TutorUniversitario>();
	list=(ArrayList<TutorUniversitario>) request.getAttribute("lista");
%>

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
	<main class="main oh">
	<table>
		<tr>
			<th>Azienda</th>
			<th>Tutor Universitario</th>
			<th>Seleziona</th>
		</tr>
	<%for(int i=0;i<lista.size(); i++){%>
		<tr>
			<td><form name="prendiazienda" action="PrendiNomeAzienda"
					method="post">
					<input type="hidden" name="azienda"
						value="<%=lista.get(i).getNomeazienda()%>">
				</form></td>
			<td><div class="form-group">
					<select class="form-control" name="sel">
					<%for(int j=0;j<list.size(); j++){%>
						<option><%=list.get(i).getNome()%> <%=list.get(i).getCognome()%></option>
						<%}%>
					</select>
				</div></td>
			<td><div class="radio">
					<label><input type="radio" name="optradio"></label>
				</div></td>
		</tr>
		<%} %>
		
		
		
		<!-- <tr>
			<td><form name="prendiazienda" action="PrendiNomeAzienda"
					method="post"></form>
				<input type="hidden" name="azienda"
				value="<%=lista.get(1).getNomeazienda()%>"></td>
			<td><div class="form-group">
					<select class="form-control" id="sel2">
						<%for(int i=0;i<list.size(); i++){%>
						<option><%=list.get(i).getNome()%> <%=list.get(i).getCognome()%></option>
						<%}%>
					</select>
				</div></td>
			<td><div class="radio">
					<label><input type="radio" name="optradio"></label>
				</div></td>
		</tr>
		<tr>
			<td><form name="prendiazienda" action="PrendiNomeAzienda"
					method="post"></form>
				<input type="hidden" name="azienda"
				value="<%=lista.get(2).getNomeazienda()%>"></td>
			<td><div class="form-group">
					<select class="form-control" id="sel3">
						<%for(int i=0;i<list.size(); i++){%>
						<option><%=list.get(i).getNome()%> <%=list.get(i).getCognome()%></option>
						<%}%>
					</select>
				</div></td>
			<td><div class="radio">
					<label><input type="radio" name="optradio"></label>
				</div></td>
		</tr>
		<%
			if (lista.size() > 2) {
		%>
		<tr>
			<td><form name="prendiazienda" action="PrendiNomeAzienda"
					method="post"></form>
				<input type="hidden" name="azienda"
				value="<%=lista.get(3).getNomeazienda()%>"></td>
			<td><div class="form-group">
					<select class="form-control" id="sel3">
						<%for(int i=0;i<list.size(); i++){%>
						<option><%=list.get(i).getNome()%> <%=list.get(i).getCognome()%></option>
						<%}%>
					</select>
				</div></td>
			<td><div class="radio">
					<label><input type="radio" name="optradio"></label>
				</div></td>
		</tr>
		<%
			}
		%>
		-->
		
		
		
	</table>
	<div>
		<button type="button" class="btn btn-primary"
			style="text-align: center">Primary</button>
	</div>
	<div class="gmap gmap-hidden" id="google-map"
		data-address="V Tytana St, Manila, Philippines"></div>


	<!-- Footer --> <footer class="footer">


		<div class="footer-bottom">
			<div class="container">
				<div class="row">

					<div class="col-sm-6 col-xs-12 text-sm-center">
						<span class="copyright"> 2017 Canna Theme | Made by <a
							href="https://deothemes.com">DeoThemes</a>
						</span>
					</div>

					<div
						class="col-sm-4 col-sm-offset-2 col-xs-12 text-right text-sm-center">
						<div class="socials socials--nobase footer__socials clearfix">
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
	</footer> <!-- end footer -->

	<div id="back-to-top" class="">
		<a href="#top"><i class="fa fa-angle-up"></i></a>
	</div>

	</main>
	<!-- end main-wrapper -->

	<!-- jQuery Scripts -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
	<script type="text/javascript" src="js/gmap3.js"></script>
	<script type="text/javascript" src="js/plugins.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>


	<!-- Google Map -->
	<script type="text/javascript">
		$(document).ready(function() {

			function initMap() {

				var gmapDiv = $("#google-map");
				var gmapMarker = gmapDiv.attr("data-address");

				gmapDiv.gmap3({
					zoom : 16,
					address : gmapMarker,
					oomControl : true,
					navigationControl : true,
					scrollwheel : false,
					styles : [ {
						"featureType" : "all",
						"elementType" : "all",
						"stylers" : [ {
							"saturation" : "0"
						} ]
					} ]
				}).marker({
					address : gmapMarker,
					icon : "img/map_pin.png"
				}).infowindow({
					content : "V Tytana St, Manila, Philippines"
				}).then(function(infowindow) {
					var map = this.get(0);
					var marker = this.get(1);
					marker.addListener('click', function() {
						infowindow.open(map, marker);
					});
				});
			}

			// Map Button
			$(".gmap-btn").on("click", function() {

				$(".gmap").slideToggle();

				if ($(this).text() == "Close Map")
					$(this).text("Open Map")
				else
					$(this).text("Close Map");
			});

			$(".gmap-btn").one("click", function() {
				setTimeout(function() {
					initMap();
				}, 500);
			});

		});
	</script>

</body>
</html>
