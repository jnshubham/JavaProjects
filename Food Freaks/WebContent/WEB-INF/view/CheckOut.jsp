<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap Core CSS -->
    <link href="Designing/FrontDesign/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Fonts -->
    <link href="Designing/FrontDesign/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="Designing/FrontDesign/css/animate.css" rel="stylesheet" />
    <!-- Squad theme CSS -->
    <link href="Designing/FrontDesign/css/style.css" rel="stylesheet">
	<link href="Designing/FrontDesign/color/default.css" rel="stylesheet">

<title>Order Successful...</title>
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="home.html">
                    <img src="Designing/AppPage/img/logo.png" alt="Food Freaks"/><font color="white" size="4">FOOD FREAKS</font>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="home.html">Home</a></li>
        <li><a href="#about">About</a></li>
		<li><a href="#service">Service</a></li>
		<li><a href="#contact">Contact</a></li>
		<li><a href="cityselect.html">Search</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Login<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="adminlogin.html">Admin Login</a></li>
            <li><a href="userlogin.html?chk=0">Employee Login</a></li>
          </ul>
        </li>
      </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <section id="about" class="home-section text-center">
		<div class="heading-about">
			<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
					<div class="section-heading">
					<h2>Order Successful</h2>
					<i class="fa fa-2x fa-angle-down"></i>
<h3>Your Order is <font color="green"><b>Successfully Placed!</b></font></h3>
		</div>
					</div>
				</div>
			</div>
			</div>
		</div>
    
    
	<!-- Section: contact -->
    <section id="contact" class="home-section text-center">
		<div class="heading-contact">
			<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
					<div class="section-heading">
					<h2>Get in touch</h2>
					<i class="fa fa-2x fa-angle-down"></i>

					</div>
					</div>
				</div>
			</div>
			</div>
		</div>
		<div class="container">

		<div class="row">
			<div class="col-lg-2 col-lg-offset-5">
				<hr class="marginbot-50">
			</div>
		</div>
    <div class="row">
        <div class="col-lg-8">
            <div class="boxed-grey">
                <form id="contact-form">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Name</label>
                            <input type="text" class="form-control" id="name" placeholder="Enter name" required="required" />
                        </div>
                        <div class="form-group">
                            <label for="email">
                                Email Address</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="email" class="form-control" id="email" placeholder="Enter email" required="required" /></div>
                        </div>
                        <div class="form-group">
                            <label for="subject">
                                Subject</label>
                            <select id="subject" name="subject" class="form-control" required="required">
                                <option value="na" selected="">Choose One:</option>
                                <option value="service">General Customer Service</option>
                                <option value="suggestions">Suggestions</option>
                                <option value="product">Product Support</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Message</label>
                            <textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required"
                                placeholder="Message"></textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-skin pull-right" id="btnContactUs">
                            Send Message</button>
                    </div>
                </div>
                </form>
            </div>
        </div>

		<div class="col-lg-4">
			<div class="widget-contact">
				<h5>Main Office</h5>

				<address>
				  <strong>Food Freaks pvt. Ltd.</strong><br>
				  85-Mayur Market<br>
				  Thatipur, Gwalior 474011<br>
				  <abbr title="Phone">M:</abbr> +91-7828733244
				</address>

				<address>
				  <strong>Email</strong><br>
				  <a href="mailto:#">shubhamakachamp@gmail.com</a>
				</address>
				<address>
				  <strong>We're on social networks</strong><br>
                       	<ul class="company-social">
                            <li class="social-facebook"><a href="www.facebook.com/shubham0307" target="_blank"><i class="fa fa-facebook"></i></a></li>
                            <li class="social-twitter"><a href="#" target="_blank"><i class="fa fa-twitter"></i></a></li>
                            <li class="social-dribble"><a href="#" target="_blank"><i class="fa fa-dribbble"></i></a></li>
                            <li class="social-google"><a href="#" target="_blank"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
				</address>

			</div>
		</div>
    </div>

		</div>
	</section>
	<!-- /Section: contact -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<div class="wow shake" data-wow-delay="0.4s">
					<div class="page-scroll marginbot-30">
						<a href="#intro" id="totop" class="btn btn-circle">
							<i class="fa fa-angle-double-up animated"></i>
						</a>
					</div>
					</div>
					<p>&copy;Copyright 2016 - Food Freaks. All rights reserved. <a href="home.html">Responsive Support</a> by Shubham Jain</p>
                    
				</div>
			</div>
		</div>
	</footer>

    <!-- Core JavaScript Files -->
    <script src="Designing/FrontDesign/js/jquery.min.js"></script>
    <script src="Designing/FrontDesign/js/bootstrap.min.js"></script>
    <script src="Designing/FrontDesign/js/jquery.easing.min.js"></script>
	<script src="Designing/FrontDesign/js/jquery.scrollTo.js"></script>
	<script src="Designing/FrontDesign/js/wow.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="Designing/FrontDesign/js/custom.js"></script>
</body>
</html>