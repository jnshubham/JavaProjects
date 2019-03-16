<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="Checks/Chk1.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="jquery.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
</head>
<body>
<form:form action="changepassword.html" method="POST" onsubmit="return validate();">
<table>
<tr>
    <td><form:label path="oldpassword">Old Password: </form:label></td>
    <td><form:input path="oldpassword" id="oldpassword"/></td>
</tr>

<tr>
    <td><form:label path="newpassword">New Password: </form:label></td>
    <td><form:input path="newpassword" id="newpassword"/></td>
</tr>
<tr>
    <td><form:label path="cnewpassword">Confirm New Password: </form:label></td>
    <td><form:input path="cnewpassword" id="cnewpassword"/></td>
    <td><span id="msgcnewpassword"></span></td>
</tr>

<tr>
    <td><button type="submit">Submit</button></td>
    <td><button type="reset">Clear</button></td>
</tr>

<tr>
    <td></td>
    <td></td>
</tr>
</table>



</form:form>
</body>
</html>