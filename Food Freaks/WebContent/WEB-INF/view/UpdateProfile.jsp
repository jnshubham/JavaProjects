<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="Checks/Chk.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

<title>Update Profile</title>
<script src="jquery.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).on("change", '#state', function(e) {
	var state = $("#state").val();
	//alert(state);
	 $.ajax({
			contentType : "application/json",
			processData : true,
			async : true,
			url : "displayCity1.html",
			type : "GET",
			dataType: "json",
			data : "state="+state,
		    cache: false,
			success : function(response) {	
				
				 var select = $('#city');
			        select.find('option').remove();
			        $('<option>').val("").text("---Select City---").appendTo(select);
			        $.each(response, function(key, value) {
			          $('<option>').val(value[0]).text(value[1]).appendTo(select);
			        });
			    }
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
                <a class="navbar-brand" href="userhome.html">
                    <img src="Designing/AppPage/img/logo.png" alt="Food Freaks"/><font color="white" size="4">FOOD FREAKS</font>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="userhome.html">Home</a></li>
        <li><a href="previousorders.html">Previous Orders</a></li>
		<li><a href="updateprofile.html?userid=${sid}">Update Profile</a></li>
		<li><a href="#contact">Contact</a></li>
		<li><a href="cityselect.html">Search</a></li>
        <li><a href="home.html">LogOut</a></li>
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
					<h2>Update Profile</h2>
					<i class="fa fa-2x fa-angle-down"></i>
					
					<form:form action="userupdate.html" method="POST" onsubmit="return validate();">
<div class="table-respoonsive">
	<table class="table ">
<caption><h4>User Registration</h4></caption>

<tr>
    <td><form:label path="userid">User ID :</form:label></td>
    <td><form:input path="userid" id="userid" readonly="true" class="form-control" /></td>
</tr>
<tr>
    <td><form:label path="username">User Name :</form:label></td>
    <td><form:input path="username" id="username" value="${user.username}" class="form-control"/></td>
    <td><span id="msgusername"></span></td>
</tr>
<tr>
    <td><form:label path="address">Address :</form:label></td>
    <td><form:input path="address" id="address" value="${user.address}" class="form-control"/></td>
    <td><span id="msgaddress"></span></td>
</tr>



<tr>
    <td><form:label path="state">State :</form:label></td>
    <td><form:select path="state" id="state" class="form-control" >
    
              <form:option value="" label="--- Select ---"/>
   			     <c:forEach items="${stateList}" var="c">
   			  <form:option value="${c.stateid}">${c.statename}</form:option>	
   				 </c:forEach>
     
    </form:select></td>
     <td><span id="msgstate"></span></td>
</tr>




<tr>
    <td><form:label path="cities.cityid">City :</form:label></td>
    <td><form:select path="cities.cityid" id="city" class="form-control">
       <form:option value="" label="--- Select ---"/>
      
      
    </form:select></td>
    <td><span id="msgcity"></span></td>
</tr>


<tr>
    <td><form:label path="gender">Status :</form:label></td>
    <td><form:radiobutton path="gender" value="Male" selected="true"/>Male <form:radiobutton path="gender" value="Female"/>Female</td>
</tr>
<tr>
    <td><form:label path="dob" type="calander">Date of Birth :</form:label></td>
    <td><form:input path="dob" id="dob" value="${user.dob}" class="form-control"/></td>
     <td><span id="msgdob"></span></td>
</tr>
<tr>
    <td><form:label path="emailid" >Email ID :</form:label></td>
    <td><form:input path="emailid" id="emailid" value="${user.emailid}" class="form-control"/></td>
    <td><span id="msgemailid"></span></td>
</tr>
<tr>
    <td><form:label path="contact">Contact No :</form:label></td>
    <td><form:input path="contact" id="contact" value="${user.contact}" class="form-control"/></td>
    <td><span id="msgcontact"></span></td>
</tr>
<tr>
    <td><form:label path="picture">Picture :</form:label></td>
    <td><form:input path="picture" id="picture" type="file" value="${user.picture}" class="form-control"/></td>
    <td><span id="msgpicture"></span></td>
</tr>
<tr>
   
    <td><form:label path="password" onkeydown="pwdStrength();">Password :</form:label></td>
    <td><form:password path="password" id="password" class="form-control"/></td>
    <td><span id="msgpassword"></span></td>
</tr>
<tr>
    <td><form:label path="cpassword">Confirm Password :</form:label></td>
    <td><form:password path="cpassword" id="cpassword" class="form-control"/></td>
    <td><span id="msgcpassword"></span></td>
</tr>
<tr>
<td><button type="reset" class="form-control">Clear</button></td>
    <td><button type="submit" class="btn btn-primary">Update</button></td>
    
</tr>


</table>
</div>
</form:form>
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