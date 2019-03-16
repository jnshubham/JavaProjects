<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="Checks/HotelsChks.js"></script>
<script src="jquery.js" type="text/javascript"></script>
<script type="text/javascript">


$(document).on("change", '#state', function(e) {
	var state = $("#state").val();
	alert(state);
	 $.ajax({
			contentType : "application/json",
			processData : true,
			async : true,
			url : "displayCity.html",
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

<script type="text/javascript">
$(document).on("change", '#city', function(e) {
	var city = $("#city").val();
	alert(city);
	 $.ajax({
			contentType : "application/json",
			processData : true,
			async : true,
			url : "displayLocations.html",
			type : "GET",
			dataType: "json",
			data : "city="+city,
		    cache: false,
			success : function(response) {	
				
				 var select = $('#location');
			        select.find('option').remove();
			        $('<option>').val("").text("---Select Location---").appendTo(select);
			        $.each(response, function(key, value) {
			          $('<option>').val(value[0]).text(value[1]).appendTo(select);
			        });
			    }
	 });
});
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
                    <img src="Designing/AdminDashboard/img/shubham.png" class="user-image img-responsive"/>
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
			<form:form action="savehotel.html" method="POST" onsubmit="return validation();">
	<div class="table-respoonsive">
		<table align="center" class="table">

<caption>Hotels</caption>

<tr>
    <td><form:label path="hotelid">Hotel ID :</form:label></td>
    <td><form:input path="hotelid"  readonly="true" value="${autogen}" class="form-control"/></td>
</tr>
<tr>
    <td><form:label path="hotelname">Hotel Name :</form:label></td>
    <td><form:input path="hotelname" value="${hotel.hotelname}" id="hotelname" onkeyup="chkhotelname();" class="form-control"/></td>
    <td><span id="msghotelname"></span></td>
</tr>
<tr>
    <td><form:label path="address">Address :</form:label></td>
    <td><form:input path="address" value="${hotel.address}" id="address" class="form-control"/></td>
    <td><span id="msgaddress"></span></td>
</tr>



<tr>
    <td><form:label path="state">State :</form:label></td>
    <td><form:select path="state" id="state" value="${hotel.state}" class="form-control">
    
              <form:option value="" label="--- Select ---"/>
   			     <c:forEach items="${stateList}" var="c">
   			  <form:option value="${c.stateid}">${c.statename}</form:option>	
   				 </c:forEach>
     
    </form:select></td>
     <td><span id="msgstate"></span></td>
</tr>




<tr>
    <td><form:label path="cities.cityid">City :</form:label></td>
    <td><form:select path="cities.cityid" id="city" value="${hotel.cities.cityname}" class="form-control">
       <form:option value="" label="--- Select ---"/>
      
      
    </form:select></td>
    <td><span id="msgcity"></span></td>
</tr>



<tr>
    <td><form:label path="locations.locationid">Location Name :</form:label></td>
    <td><form:select path="locations.locationid" id="location" value="${hotel.locations.locationname}" class="form-control">
       <form:option value="" label="--- Select ---"/>
            
    </form:select></td>
     <td><span id="msglocation"></span></td> 

</tr>
<tr>
    <td><form:label path="pin">Pin :</form:label></td>
    <td><form:input path="pin" value="${hotel.pin}" id="pin" class="form-control"/></td>
     <td><span id="msgpin"></span></td>
</tr>
<tr>
    <td><form:label path="latitude">Latitude,Longitude :</form:label></td>
    <td><form:input path="latitude" value="${hotel.latitude}" id="latitude" class="form-control"/></td>
     <td><span id="msglatitude"></span></td>
</tr>
<tr>
    <td><form:label path="emailid">Email ID :</form:label></td>
    <td><form:input path="emailid" value="${hotel.emailid}" id="emailid" class="form-control"/></td>
    <td><span id="msgemailid"></span></td>
</tr>
<tr>
    <td><form:label path="contactno">Contact No :</form:label></td>
    <td><form:input path="contactno" value="${hotel.contactno}" id="contactno" class="form-control"/></td>
    <td><span id="msgcontactno"></span></td>
</tr>
<tr>
    <td><form:label path="ownername">Owner Name :</form:label></td>
    <td><form:input path="ownername" value="${hotel.ownername}" id="ownername" class="form-control"/></td>
    <td><span id="msgownername"></span></td>
</tr>
<tr>
    <td><form:label path="status">Status :</form:label></td>
    <td><form:radiobutton path="status" value="Veg" selected="true" class="form-control"/>Veg <form:radiobutton path="status" value="Non-Veg" class="form-control"/>Non-Veg</td>
</tr>
<tr>
    <td><button type="submit" class="form-control">Submit</button></td>
    <td><button type="reset" class="form-control">Clear</button></td>
</tr>


</table>
</div>
</form:form><br><br><br>


<c:if test="${! empty hotelList}">
	<div class="table-respoonsive">
		<table align="center" class="table table-bordered">

	<thead>
		<tr >
			<th>Hotel ID</th>
			<th>Hotel Name</th>
			<th>Address</th>
			<th>City</th>
			<th>Location Name</th>
			<th>Pin</th>
			<th>Latitude, Longitude</th>
			<th>Email ID</th>
			<th>Contact No</th>
			<th>Owner Name</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>	
		<c:forEach items="${hotelList}" var="c">
			<tr>
				<td><c:out value="${c[0]}"/></td>
				<td><c:out value="${c[1]}"/></td>
				<td><c:out value="${c[2]}"/></td>
				<td><c:out value="${c[3].cityname}"/></td>
				<td><c:out value="${c[4].locationname}"/></td>
				<td><c:out value="${c[5]}"/></td>
				<td><c:out value="${c[6]}"/></td>
				<td><c:out value="${c[7]}"/></td>
				<td><c:out value="${c[8]}"/></td>
				<td><c:out value="${c[9]}"/></td>
				<td><c:out value="${c[10]}"/></td>
				<td align="center"><a href="edithotel.html?hotelid=${c[0]}">Edit</a> | <a href="deletehotel.html?hotelid=${c[0]}">Delete</a></td>
			
				
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