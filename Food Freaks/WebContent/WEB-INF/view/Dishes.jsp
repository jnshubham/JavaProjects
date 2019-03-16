<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    
    
<script type="text/javascript" src="Checks/DishesChks.js"></script>
<script src="jquery.js" type="text/javascript"></script>
<script type="text/javascript">


$(function() {
	call();
	
});

  function call()
  {
	  
	  
	  var menu = $("#menu").val();
		 $.ajax({
				contentType : "application/json",
				processData : true,
				async : true,
				url : "showMenus.html",
				type : "GET",
				dataType: "json",
			    cache: false,
				success : function(response) {	
					
					 var select = $('#menu');
				        select.find('option').remove();
				        $('<option>').val("").text("---Select Menu---").appendTo(select);
				        $.each(response, function(key, value) {
				        	//alert(value.menuid);
				          $('<option>').val(value.menuid).text(value.menuname).appendTo(select);
				        });
  
			    }
	 });
}
</script>
    
    
    
    
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
			<form:form action="savedish.html" method="post" onsubmit="return validation();">
				<div class="table-respoonsive">
				<table align="center" class="table">
					<caption>Dishes</caption>
					<tr>
    					<td><form:label path="dishid">Dish ID :</form:label></td>
    					<td><form:input path="dishid"  readonly="true" class="form-control" value="${autogen}"/></td>
					</tr>

<tr>
    <td><form:label path="menus.menuid">Menu Name :</form:label></td>
    <td><form:select path="menus.menuid" id="menu" value="${dishes.menus.menuname}" class="form-control">
       <form:option value="" label="--- Select ---"/>
      
      
    </form:select></td>
    <td><span id="msgmenu"></span></td>
</tr>

<tr>
    <td><form:label path="dishname">Dish Name :</form:label></td>
    <td><form:input path="dishname" id="dishname" value="${dish.dishname}" class="form-control"/></td>
    <td><span id="msgdishname"></span></td>
</tr>
<tr>
    <td><form:label path="description">Description :</form:label></td>
    <td><form:input path="description" id="description" value="${dish.description}" class="form-control"/></td>
    <td><span id="msgdescription"></span></td>
</tr>
<tr>
    <td><form:label path="icon">Icon :</form:label></td>
    <td><form:input path="icon" id="icon" type="file" class="form-control"/></td>
    <td><span id="msgicon"></span></td>
</tr>
<tr>
    <td><form:label path="price">Price :</form:label></td>
    <td><form:input path="price" id="price" value="${dish.price}" class="form-control"/></td>
    <td><span id="msgprice"></span></td>
</tr>
<tr>
    <td><form:label path="specialoffer">Special Offer :</form:label></td>
    <td><form:input path="specialoffer" id="specialoffer" value="${dish.specialoffer}" class="form-control"/></td>
    <td><span id="msgspecialoffer"></span></td>
</tr>
<tr>
    <td><button type="submit" class="form-control">Submit</button></td>
    <td><button type="reset" class="form-control">Clear</button></td>
</tr>
</table>
</div>
</form:form><br><br><br>
<c:if test="${! empty dishList}">
	<div class="table-respoonsive">
		<table align="center" class="table table-bordered">
		<thead>
			<tr>
		    	<th>Dish ID</th>
				<th>Menu Name</th>
				<th>Hotel Name</th>
				<th>Dish Name</th>
				<th>Description</th>
				<th>Icon</th>
				<th>Price</th>
				<th>Special Offer</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>	
			<c:forEach items="${dishList}" var="c">
				<tr>
					<td><c:out value="${c.dishid}"/></td>
					<td><c:out value="${c.menus.menuname}"/></td>
					<td><c:out value="${c.menus.hotels.hotelname}"/></td>
					<td><c:out value="${c.dishname}"/></td>
					<td><c:out value="${c.description}"/></td>
					<td><img src="Dish images/<c:out value="${c.icon}"/>" height="100" width="100"></img></td>
					<td><c:out value="${c.price}"/></td>
					<td><c:out value="${c.specialoffer}"/></td>
					<td align="center"><a href="editdish.html?dishid=${c.dishid}">Edit</a> | <a href="deletedish.html?dishid=${c.dishid}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>
	</div>
</c:if>
			
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
