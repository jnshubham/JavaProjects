<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Dashboard</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="Designing/AdminDashboard/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="Designing/AdminDashboard/css/font-awesome.css" rel="stylesheet" />
     <!-- MORRIS CHART STYLES-->
    <link href="Designing/AdminDashboard/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="Designing/AdminDashboard/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home.html">Admin</a>
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;">&nbsp; <a href="home.html" class="btn btn-danger square-btn-adjust">Logout</a> </div>
        </nav>
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="Designing/AdminDashboard/img/shubham.jpg" class="user-image img-responsive"/>
					</li>


                    <li>
                        <a class="active-menu"  href="adminhome.html"><i class="fa fa-dashboard fa-3x"></i> Dashboard</a>
                    </li>
                     <li>
                        <a  href="addhotel.html"><i class="fa fa-desktop fa-3x"></i>Add Hotels</a>
                    </li>
                    <li>
                        <a  href="add.html"><i class="fa fa-qrcode fa-3x"></i>Add Cuisine</a>
                    </li>
						   <li  >
                        <a   href="adddish.html"><i class="fa fa-bar-chart-o fa-3x"></i>Add Dishes</a>
                    </li>
                      <li  >
                        <a  href="cityview.html"><i class="fa fa-table fa-3x"></i>Add City</a>
                    </li>
                    <li  >
                        <a  href="home.html"><i class="fa fa-edit fa-3x"></i>Home</a>
                    </li>
            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <form:form action="savecity.html" method="post">
				<div class="table-respoonsive">
				<table align="center" class="table">
				<caption>Add City</caption>
				<tr>
				    <td><form:label path="cityid">City ID :</form:label></td>
				    <td><form:input path="cityid" class="form-control"/></td>
				</tr>
				<tr>
				    <td><form:label path="states.stateid">State Name :</form:label></td>
				    <td><form:select path="states.stateid" class="form-control">
			          <form:option value="" label="--- Select ---"/>
   				     <c:forEach items="${stateList}" var="c">
   					  <form:option value="${c.stateid}">${c.statename}</form:option>	
   					 </c:forEach>
   					 </form:select></td>
				</tr>
				<tr>
				    <td><form:label path="cityname">City Name :</form:label></td>
				    <td><form:input path="cityname" class="form-control"/></td>
				</tr>
				<tr>
				    <td><button type="submit" class="form-control">Insert</button></td>
				    <td><button type="reset" class="form-control">Clear</button></td>
				</tr>
				</table>
				</div>
				</form:form>

             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="Designing/AdminDashboard/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="Designing/AdminDashboard/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="Designing/AdminDashboard/js/jquery.metisMenu.js"></script>
     <!-- MORRIS CHART SCRIPTS -->
     <script src="Designing/AdminDashboard/js/morris/raphael-2.1.0.min.js"></script>
    <script src="Designing/AdminDashboard/js/morris/morris.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="Designing/AdminDashboard/js/custom.js"></script>


</body>
</html>














