<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Details</title>

<script src="jquery.js" type="text/javascript"></script>
<script src="jquery.cookie.js"></script>
 <link href="Designing/FrontDesign/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script>
$(function () {
	/*  $("#cart").click(function () {
	window.location="add2cart.html";
	}); */
   	 
	$(".plus").click(function () {
        var did = $(this).attr("did");
        var dn = $(this).attr("dn");
        var i = $("#" + did).html();
        //alert(i);
        var amt=$(".amt"+did);
     	//alert(amt);
 
     	i = parseInt(i) + 1;

        $("#" + did).html(i);
        
        $.cookie(did, i+","+dn);
        //alert(fid + "," + i);
        var cook=$.cookie(did);
        var value=cook.split(",");
        var s="<font color=red><strike>"+value[0]*value[2]+"</strike></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+value[0]*value[3];
        amt.html(s);
       // alert($.cookie(did));
    });


    $(".minus").click(function () {
        var did = $(this).attr("did");
        var dn = $(this).attr("dn");
        var i = $("#" + did).html();
        var amt=$(".amt"+did);
        amt.html("&nbsp;");
        if (i > 0) {
            i = parseInt(i) - 1;
            $("#" + did).html(i);
            $.cookie(did, i + "," + dn);
            var cook=$.cookie(did);
            var value=cook.split(",");
            var s="<font color=red><strike>"+value[0]*value[2]+"</strike></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+value[0]*value[3];
            amt.html(s);
          //  alert($.cookie(did));
        }
    });



});
</script>

</head>
<body>

<c:if test="${! empty dishlist}">
	
	<center><h1>Dishes</h1></center>
	<div class="table-respoonsive">
	<table class="table table-hover">
	<thead>
		
		<tr >
			<th>Dish Image&nbsp;&nbsp;</th>
			<th>&nbsp;&nbsp;&nbsp;Dish Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<!-- <th>&nbsp;&nbsp;&nbsp;Dish Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>&nbsp;&nbsp;&nbsp;Quantity&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th> 
			<th>&nbsp;&nbsp;&nbsp;Amount&nbsp;&nbsp;&nbsp;</th>-->
		</tr>
	</thead>
	<tbody>	
		<c:forEach items="${dishlist}" var="c">
			<tr>
				<td><img src="Dish images/<c:out value="${c.icon}"/>" height="100" width="100"></img></td>
				<td>&nbsp;&nbsp;&nbsp;<c:out value="${c.dishname}"/><br><br>
				&nbsp;&nbsp;&nbsp;<font color="red"><strike><c:out value="${c.price}"/></strike></font>
				&nbsp;&nbsp;&nbsp;<c:out value="${c.specialoffer}"/><br><br>
				&nbsp;&nbsp;&nbsp;<input type="button" value="+" class="plus" did="${c.dishid}" dn="${c.dishname},${c.price},${c.specialoffer}"></input><span id="${c.dishid}">0</span><input type="button" value="-" class="minus" did="${c.dishid}" dn="${c.dishname},${c.price}, ${c.specialoffer}"></input><br><br>
				&nbsp;&nbsp;&nbsp;<label class="amt${c.dishid}"></label></td>
			</tr>
		</c:forEach>
	</tbody>		
	</table>
	</div>
</c:if>
<%-- <center>
<input type="button" value="Proceed to Cart" id="cart" >
</center> --%>

</body>
</html>