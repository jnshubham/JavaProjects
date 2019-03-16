function isBlank(txt)
{
	if(txt.value.length==0)
		{
		return true;
		}
	return false;
}

function isAlpha(txt)
{  //alert(txt.value.length);
   for(var i=0;i<txt.value.length;i++)
	   {
	   var c=txt.value.charCodeAt(i);
	   if(!((c>=65 && c<=90)||(c>=97 && c<=122)))
        {return false;}	   
	   }
      return true;
}


function isDigit(txt)
{   var result=true;
	for(var i=0;i<txt.value.length;i++)
	{
	  c=txt.value.charCodeAt(i);
	  if(!(c>=48 && c<=57))
	  {
	    result=false;
	    break;
	  }
	}
  return(result);
}




function checkMobile(txt)
{
	if(txt.value.length!=10)
		{
		return(false);
		}
	return(true);	
}


function checkPin(txt)
{
	if(txt.value.length!=7)
		{
		return(false);
		}
	return(true);	
}


function chkEmailid(txt)
{  //alert(txt.value.length);
   for(var i=0;i<txt.value.length;i++)
	   {
	   var c=txt.value.charCodeAt(i);
	   alert(c);
	   if(c==64)           /////////// 64 means @
        {
	
		   return true;}	   
	   }
      return false;
}
///////////////////////////////////////////////////////////////////////





function chkhotelname()
{
	var hotelname=document.getElementById("hotelname");
 	var msghotelname=document.getElementById("msghotelname");
 	
 	msghotelname.innerHTML="";
 	if(!isAlpha(hotelname))
 	{
 		msghotelname.innerHTML="<img src=pic/wrong.png>";
 		return false;
 	}
 	else
 		{
 		
 		msghotelname.innerHTML="<img src=pic/correct.png>";
 		return true;
 		}


}
















/////////////////////////////////

function validation()
{
	//alert("aaaa");
	var result=false;
 	
	var hotelname=document.getElementById("hotelname");
 	var msghotelname=document.getElementById("msghotelname");
 	
 	var address=document.getElementById("address");
 	var msgaddress=document.getElementById("msgaddress");
 	
 	var state=document.getElementById("state");
 	var msgstate=document.getElementById("msgstate");
 	
 	var city=document.getElementById("city");
 	var msgcity=document.getElementById("msgcity");
 	
 	var location=document.getElementById("location");
 	var msglocation=document.getElementById("msglocation");
 	
 	var pin=document.getElementById("pin");
 	var msgpin=document.getElementById("msgpin");
 	
 	var latitude=document.getElementById("latitude");
 	var msglatitude=document.getElementById("msglatitude");
 	
 	var emailid=document.getElementById("emailid");
 	var msgemailid=document.getElementById("msgemailid");
 	
 	var contactno=document.getElementById("contactno");
 	var msgcontactno=document.getElementById("msgcontactno");
 	
 	var ownername=document.getElementById("ownername");
 	var msgownername=document.getElementById("msgownername");
 	
 	
 	
 	
 	////////////// For Hotel Name //////////////
 	 
 	msghotelname.innerHTML="";
 	if(isBlank(hotelname))
 	{
 		msghotelname.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		if(chkhotelname())
 		{
 			msghotelname.innerHTML="<img src=pic/correct.png>";
 		}
 		else
 		{
 			msghotelname.innerHTML="<img src=pic/wrong.png>";
 			result=false;
 		}
 	   
 	}
 	
 	
 	
 	
 	
	
//////////////For Address //////////////
 	
 	msgaddress.innerHTML="";
 	if(isBlank(address))
 	{
 		msgaddress.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		msgaddress.innerHTML="<img src=pic/correct.png>";
 	}
 
 	
 	
 	
 	
 	
//////////////For State //////////////
 	
 	msgstate.innerHTML="";
 	if(isBlank(state))
 	{
 		msgstate.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		msgstate.innerHTML="<img src=pic/correct.png>";
 	}
 	
 	
 	
 	
 	
//////////////For City //////////////
 	
 	msgcity.innerHTML="";
 	if(isBlank(city))
 	{
 		msgcity.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		msgcity.innerHTML="<img src=pic/correct.png>";
 	}
 	
 	
 	
 	
 	
 	
 	
//////////////For Location //////////////
 	
 	msglocation.innerHTML="";
 	if(isBlank(location))
 	{
 		msglocation.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		msglocation.innerHTML="<img src=pic/correct.png>";
 	}
 	
 	
 	
 	
//////////////For Pin //////////////
 	
 	msgpin.innerHTML="";
 	if(isBlank(pin))
 	{
 		msgpin.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else if(!isBlank(pin))
	{
	  if(isDigit(pin))
	  { 
		 if(!checkPin(pin))
	 	 {
	 	   result=false;
		   msgpin.innerHTML="<font color=red><b><i>Pin No Must Be 7 Digits..</b></i></font>";
	 	 }
	  }
	  else
	 	{
	 	   result=false;
		   msgpin.innerHTML="<font color=red><b><i>Allow Only Digits..</b></i></font>";
	 	
	 	}
	  
	}
 	
 	
 	
 	
 	
 	
//////////////For Latitude //////////////
 	
 	msglatitude.innerHTML="";
 	if(isBlank(latitude))
 	{
 		msglatitude.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		msglatitude.innerHTML="<img src=pic/correct.png>";
 	}
 	
 	
 	
 	
 	
//////////////For Email ID //////////////
 	
 	msgemailid.innerHTML="";
 	if(isBlank(emailid))
 	{
 		msgemailid.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		if(chkEmailid(emailid))
 		{
 			msgemailid.innerHTML="<img src=pic/correct.png>";
 		}
 		else
 		{
 			msgemailid.innerHTML="<font color=red>Email Id should be contain @</font>";
 		}
 	}
 	
 	
 	
 	
 	
 	
//////////////For Contact No //////////////
 	
 	msgcontactno.innerHTML=""; 
	if(isBlank(contactno))
	{
		  result=false;
		  msgcontactno.innerHTML="<img src=pic/wrong.png>";
		 
	}
	else if(!isBlank(contactno))
	{
	  if(isDigit(contactno))
	  { 
		 if(!checkMobile(contactno))
	 	 {
	 	   result=false;
		   msgcontactno.innerHTML="<font color=red><b><i>Mobile No Must Be 10 Digits..</b></i></font>";
	 	 }
	  }
	  else
	 	{
	 	   result=false;
		   msgcontactno.innerHTML="<font color=red><b><i>Allow Only Digits..</b></i></font>";
	 	
	 	}
	}
	
	
	
	
//////////////For Owner Name //////////////
	
	msgownername.innerHTML="";
 	if(isBlank(ownername))
 	{
 		msgownername.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		if(isAlpha(ownername))
 		{
 			msgownername.innerHTML="<img src=pic/correct.png>";
 		}
 		else
 		{
 			msgownername.innerHTML="<img src=pic/wrong.png>";
 			result=false;
 		}
 	}
 	
 	
 	
 	
 	
 	return result;
}