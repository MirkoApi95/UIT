<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en" class="mediaqueries matchmedia mediaqueries matchmedia"><head>
  <title>UIT Home</title>

  <meta charset="utf-8">
  <!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="description" content="">

  <!-- Google Fonts -->
  <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700%7CSource+Sans+Pro:400,300,700,600%7CPlayfair+Display:400,700,400italic" rel="stylesheet">

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
  <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
  <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">
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
            <input type="search" class="nav__search-input" placeholder="Type &amp; Hit Enter">
            <i class="fa fa-close nav__search-close" id="nav__search-close"></i>
          </form>

          <div class="nav__header clearfix">
            <!-- Logo -->
            <div class="logo-wrap">
              <a href="index.html" class="logo__link">
                <img class="logo logo--dark" src="img/logo2.png" alt="logo">
              </a>
            </div>
            <button type="button" class="nav__icon-toggle" id="nav__icon-toggle" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="true">
              <span class="sr-only">Toggle navigation</span>
              <span class="nav__icon-toggle-bar"></span>
              <span class="nav__icon-toggle-bar"></span>
              <span class="nav__icon-toggle-bar"></span>
            </button>
          </div> <!-- end nav-header -->
          <nav id="navbar-collapse" class="nav__wrap navbar-collapse collapse in" aria-expanded="true" style="">
            <ul class="nav__menu">
            </ul> <!-- end menu -->

          </nav> <!-- end nav-wrap -->

        </div> <!-- end flex-parent -->
      </div> <!-- end container -->

    </div>
  </header> <!-- end navigation -->



    <div class="container">
	<div class="row">
	<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend> Progetto Formativo e di Orientamento</legend>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Name">Nome  </label>
  <div class="col-md-5">
  <input id="Name" name="Name" type="text" class="form-control input-md" required="">

  </div>
</div>

<!-- Cognome input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Cognome</label>
  <div class="col-md-5">
    <input id="surnameinput" name="surnameinput" type="text" class="form-control input-md" required="">
  </div>
</div>

<!-- Address input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">Matricola</label>
  <div class="col-md-5">
    <input id="matricola" name="matricola" type="text" class="form-control input-md" required="">
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">CFU Acquisiti</label>
  <div class="col-md-4 col-lg-5">
    <input type="text" class="form-control" id="cfu" name="cfu">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="emailId">Anno Iscrizione</label>
  <div class="col-md-5 col-lg-5">
  <input id="annoiscr" name="annoiscr" type="text" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="emailId">Anno in corso</label>
  <div class="col-md-5 col-lg-5">
  <input id="annocorso" name="annocorso" type="text" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="azienda">Azienda/Ente Ospitante</label>
  <div class="col-md-5 col-lg-5">
  <input id="azienda" name="azienda" type="text" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="tutoraziendale">Tutor Aziendale</label>
  <div class="col-md-5 col-lg-5">
  <input id="tutoraziendale" name="tutoraziendale" type="text" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Tutor Accademico">Tutor Accademico</label>
  <div class="col-md-5 col-lg-5">
  <input id="tutoraccademico" name="tutoraccademico" type="text" class="form-control input-md" required="">
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">Obiettivi e finalita' </label>
  <div class="col-md-4 col-lg-5">
    <textarea class="form-control" id="obiettivi" name="obiettivi" placeholder="Compila il campo con gli obiettivi e le finalita'"></textarea>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4 col-lg-1">
    <button id="submit" name="submit" class="btn btn-success">Submit</button>
  </div>
</div>

</fieldset>
</form>
	</div>
</div>

    <footer class="footer">


      <div class="footer-bottom">
        <div class="container">
          <div class="row">

            <div class="col-sm-6 col-xs-12">
              <span class="copyright">
                © Made by UIT Team
              </span>
            </div>

            <div class="col-sm-4 col-sm-offset-2 col-xs-12 clearfix">
              <div class="socials socials--nobase footer__socials clearfix right">
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-google-plus"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-vimeo"></i></a>
                <a href="#"><i class="fa fa-instagram"></i></a>
              </div>
            </div>

          </div>
        </div>
      </div> <!-- end bottom footer -->
    </footer> <!-- end footer -->

    <div id="back-to-top" class="">
      <a href="#top"><i class="fa fa-angle-up"></i></a>
    </div>


  <!-- jQuery Scripts -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/plugins.js"></script>
  <script type="text/javascript" src="revolution/js/jquery.themepunch.tools.min.js"></script>
  <script type="text/javascript" src="revolution/js/jquery.themepunch.revolution.min.js"></script>
  <script type="text/javascript" src="js/rev-slider.js"></script>
  <script type="text/javascript" src="js/scripts.js"></script>

  <!-- Rev Slider Offline Scripts -->
  <script type="text/javascript" src="revolution/js/extensions/revolution.extension.video.min.js"></script>
  <script type="text/javascript" src="revolution/js/extensions/revolution.extension.carousel.min.js"></script>
  <script type="text/javascript" src="revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
  <script type="text/javascript" src="revolution/js/extensions/revolution.extension.actions.min.js"></script>
  <script type="text/javascript" src="revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
  <script type="text/javascript" src="revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
  <script type="text/javascript" src="revolution/js/extensions/revolution.extension.navigation.min.js"></script>
  <script type="text/javascript" src="revolution/js/extensions/revolution.extension.migration.min.js"></script>
  <script type="text/javascript" src="revolution/js/extensions/revolution.extension.parallax.min.js"></script>




</body></html>
