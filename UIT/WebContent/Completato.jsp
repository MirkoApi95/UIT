<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="utente" class="entity.Utente" scope="session"></jsp:useBean>
<jsp:useBean id="tirocinante" class="entity.Tirocinante" scope="session"></jsp:useBean>
<jsp:useBean id="tutorAziendale" class="entity.TutorAziendale" scope="session"></jsp:useBean>
<jsp:useBean id="tutorUniversitario" class="entity.Utente" scope="session"></jsp:useBean>
<html lang="en" class="mediaqueries matchmedia">
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
							<a href="BackHome" class="logo__link"> <img
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


	<div class="main-wrapper oh">

		<!-- Revolution Slider -->
		<section></section>


		<!-- Feature -->
		<!-- end feature -->


		<!-- Video Section -->



		<!-- Feature 4 (iPad) -->
		<!-- end feature 4 (ipad) -->


		<!-- Mission / Vision / Results -->
		<section class="section-wrap bg-light pb-90">
			<div class="operation_completed" style="text-align: center;">
				<h4>Completato</h4>
			</div>


		</section>
		<!-- end mission/vision/results -->


		<!-- Selected Works -->
		<!-- end selected works-->


		<!-- Feature Tabs -->
		<!-- end feature tabs -->

		<!-- Feature Tabs Content -->
		<!-- end feature tabs content -->


		<!-- Results -->
		<!-- end results-->


		<!-- From Blog -->
		<!-- end from blog -->

		<!-- Call to Action 1 -->
		<!-- end call to action 1 -->

		<!-- Footer -->
		<footer class="footer">


			<div class="footer-bottom">
				<div class="container">
					<div class="row">

						<div class="col-sm-6 col-xs-12">
							<span class="copyright"> Made by UIT Team</a>
							</span>
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

	</div>
	<!-- end main-wrapper -->

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
