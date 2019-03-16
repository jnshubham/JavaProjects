<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<title>Review your order</title>
<script type="text/javascript" src="Checks/ChkOrder.js"></script>
<script src="jquery.js" type="text/javascript"></script>
<script src="jquery.cookie.js"></script>
<script>

 
$(document).ready(function () {
	
	var amt,dishname="",ta;
	$("body").ready(function () {
		var order=1;
		order=parseInt(order);
		var i=0;
		i=${sid}+" ";
		i=parseInt(i);
		//alert(i);
		if(!i)
		{
			window.location="userlogin.html?chk=1";
		} 
		else
		{
           var d,did,qty,price,dn;
           ta=0;
	        var ca = document.cookie.split(';');
	        var display=$("#s");
	        var show="<div class=table-respoonsive><table align=center class=\"table-hover table-bordered\"><thead><tr><th>Menu Icon</th><th>Dish Name</th><th>Amount</th></tr></thead><tbody>";
	        for(var i=0;i < ca.length;i++) 
	        	{
	             c = ca[i];
	       //     alert(c);
	            d=c.split('=');
	            did=d[0];
	           // alert(did);
               	var j=d[1].split('%2C');
                	qty=parseInt(j[0]);
                	dn=j[1];
                	dishname=dishname+","+dn;
                	price=parseInt(j[2]);
                	splprice=parseInt(j[3]);                	
                	amt=qty*splprice;
                   var pic=dn.replace('_','');
                   pic=pic.replace('_','');
                   pic=pic.replace('_','');
                //	pic.append(".jpg");
                	show=show+"<tr><td><img src=\"Dish images/"+pic+".jpg\" height=100 width=100 /></td><td>"+dn+"<br/>Quantity:"+qty+",Price:"+splprice+"</td><td>"+amt+"</td></tr>";
                	ta=parseInt(ta)+amt;
	        	}

	       show=show+"<tr align=center><td colspan=2><b><font color=blue size=3>Total Amount</font></b></td><td colspan=3><b><font color=blue size=3>"+ta+"</font></b></td></tr></tbody></table></div>";
	        
		       
	        display.html(show);
		}	});
	
	
	$("#b").click(function () {
	    
		var address=$("#address").val();
		var mobileno=$("#mobileno").val();
		var email=$("#email").val();
		
	     var uid=${sid}+" ";
	     uid=parseInt(uid);
	     window.location="checkout.html?amt="+ta+"&uid="+uid+"&dishname="+dishname+"&address="+address+"&mobileno="+mobileno+"&email="+email;
	 
	  });
	
	
	
	
	
	$("#free").click(function () {
		var address=$("#address").val();
		var mobileno=$("#mobileno").val();
		var email=$("#email").val();
		
	     var uid=${sid}+" ";
	     uid=parseInt(uid);
	     window.location="checkfree.html?amt="+ta+"&uid="+uid+"&dishname="+dishname+"&address="+address+"&mobileno="+mobileno+"&email="+email;
	 
	 
	  });
		
		
	
	
			
});

	</script>
	
	
	<!-- Bootstrap Core CSS -->
    <link href="Designing/FrontDesign/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Fonts -->
    <link href="Designing/FrontDesign/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="Designing/FrontDesign/css/animate.css" rel="stylesheet" />
    <!-- Squad theme CSS -->
    <link href="Designing/FrontDesign/css/style.css" rel="stylesheet">
	<link href="Designing/FrontDesign/color/default.css" rel="stylesheet">
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
					<h2>Review Your Order</h2>
					<i class="fa fa-2x fa-angle-down"></i>
					
<span id="s"></span>
<br/><br/>
<div class="table-respoonsive">
	<table class="table ">
	
	<tr><b><h3>Address</h3></b>
	</tr>
	       
	        <tr><td >Address: </td><td><input id="address" value="${user.address}" onkeyup="valiAddress();" class="form-control" /></td><td><span id="msgaddress"></span></td></tr>
	        <tr><td>City: </td><td ><input type="text" name="city" class="form-control" value="Gwalior" readonly></td></tr>
	        <tr><td>Mobile No: </td><td><input id="mobileno" type="text" class="form-control" name="mobileno" value="${user.contact}" onkeyup="valiMobile();"></td><td><span id="msgmobileno"></span></td></tr>
	        <tr><td>Email ID: </td><td><input id="email" type="text" name="emailid" class="form-control" value="${user.emailid}" onkeyup="valiEmail();"></td><td><span id="msgemail"></span></td></tr>
	        <br>
	        <br>
	        <tr><td colspan="2"><b><h4>Payment Options</h4></b></td></tr>
	        <tr><td colspan="2"><input type="radio" name="cos" checked="checked">Case on Delivery</radio></td><td></td></tr>

<tr><td colspan="2"><input type="button" value="Proceed to Checkout" id="b"  class="btn btn-primary"/></td></tr>
<tr><td colspan="2"><input type="button" value="Order For Free" id="free" class="btn btn-success" /></td></tr>
		</table></div>
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
