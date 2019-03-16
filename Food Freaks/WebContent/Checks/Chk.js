function isBlank(txt)
{  //alert(txt.value.length);
	if(txt.value.length==0)
 {return true;}
  else 
  {return false;}
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



///////////////////////////////////







function validate()
{
	
	var result=true;
	
	   
	   
	var username=document.getElementById("username");
	var msgusername=document.getElementById("msgusername");
	
	var address=document.getElementById("address");
	var msgaddress=document.getElementById("msgaddress");
	
	var state=document.getElementById("state");
	var msgstate=document.getElementById("msgstate");

	var city=document.getElementById("city");
	var msgcity=document.getElementById("msgcity");
	
	var dob=document.getElementById("dob");
	var msgdob=document.getElementById("msgdob");
	
	
	var emailid=document.getElementById("emailid");
	var msgemailid=document.getElementById("msgemailid");
	
	var contact=document.getElementById("contact");
	var msgcontact=document.getElementById("msgcontact");
	
	
	var picture=document.getElementById("picture");
	var msgpicture=document.getElementById("msgpicture");
	
	
	
	var password=document.getElementById("password");
	var msgpassword=document.getElementById("msgpassword");
	

	
	
	
	
	
	
	msgusername.innerHTML=""; 
	if(isBlank(username))
	{msgusername.innerHTML="<img src=pic/wrong.png>";
	result=false;
	 }
	if(!isBlank(username))
		{
		if(!isAlpha(username))
			{msgusername.innerHTML="<font color=red><b><i>Allow Only Alphabets.</i></b></font>";
			result=false;
			}
		}
	
	
	
	msgaddress.innerHTML="";    
	if(isBlank(address))
	  {msgaddress.innerHTML="<img src=pic/wrong.png>";
	  result=false;
	   }

	
	
	
	msgstate.innerHTML="";    
	if(isBlank(state))
	  {msgstate.innerHTML="<img src=pic/wrong.png>";
	  result=false;
	   }

	
	
	msgcity.innerHTML="";    
	if(isBlank(city))
	  {msgcity.innerHTML="<img src=pic/wrong.png>";
	  result=false;
	   }

	
	

	msgdob.innerHTML="";    
	if(isBlank(dob))
	  {msgdob.innerHTML="<img src=pic/wrong.png>";
	  result=false;
	   }
	
	
	
	msgemailid.innerHTML="";    
	if(isBlank(emailid))
	  {msgemailid.innerHTML="<img src=pic/wrong.png>";
	  result=false;
	   }

	
	
	
	

	msgcontact.innerHTML=""; 
	if(isBlank(contact))
	{
		  result=false;
		  msgcontact.innerHTML="<img src=pic/wrong.png>";
		  result=false;
	}
	else if(!isBlank(contact))
	{
	  if(isDigit(contact))
	  { 
		 if(!checkMobile(contact))
	 	 {
	 	   result=false;
		   msgcontact.innerHTML="<font color=red><b><i>Mobile No Must Be 10 Digits..</b></i></font>";
	 	 }
	  }
	  else
	 	{
	 	result=false;
		    msgcontact.innerHTML="<font color=red><b><i>Allow Only Digits..</b></i></font>";
	 	
	 	}
	}


	
	
	

	msgpicture.innerHTML="";    
	if(isBlank(picture))
	  {msgpicture.innerHTML="<img src=pic/wrong.png>";
	  result=false;
	   }
	
	
	
		
	
	
	msgpassword.innerHTML="";    
	if(isBlank(password))
	  {msgpassword.innerHTML="<img src=pic/wrong.png>";
	  result=false;
	   }
	if(!passwordmatch())
	{result=false;}
	
	
	
/*if(result="false")
	{ 
	msb.innerHTML="";
	var msb=document.getElementById("msb");
	msb.innerHTML="<font color=red><b><i>Please Fill Correct Entries.</i></b></font>";
	//sb.disabled=true;
	}
else
	{
	
	
	}*/
	//alert(result);
 return result;
}



////////////////////

function pwdStrength()
{
	var msgpassword=document.getElementById("msgpassword");
	msgpassword.innerHTML="";
	var password=document.getElementById("password");
	
	var img=document.getElementById("img");
	var l=password.value.length;
	if(l!=0)
	{
	if(l>=0 && l<=3)
	 {
	 img.src="pic/weak.png";
	 
	 }
	 else if(l>=4 && l<=6)
	 {
	 img.src="pic/fair.png";
	 
	 }
	 else if(l>=7 && l<=9)
	  {
	  img.src="pic/good.png";
	  
	 }
	 else if(l>9)
	  {
	  img.src="pic/strong.png";
	  
	 }
}
}
function passwordmatch()
{var password=document.getElementById("password").value;
var cpassword=document.getElementById("cpassword").value;
var msgcpassword=document.getElementById("msgcpassword");
 
msgcpassword.innerHTML="";
if((password.length || cpassword.length)!=0)
	{
if(password==cpassword)
	{
	msgcpassword.innerHTML="<font color=green><b>Password Matched</b></font>";
	return true;
	}
else
	{
	msgcpassword.innerHTML="<font color=red><b>Password Not Matched</b></font>";
	return false;

	
	}
	}
	
}