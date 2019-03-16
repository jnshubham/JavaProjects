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






























function valiAddress()
{
	
	var address=document.getElementById("address");
	var msgaddress=document.getElementById("msgaddress");
	
	var b=document.getElementById("b");
	var free=document.getElementById("free");
	
	var contact=document.getElementById("mobileno");
	
	
	
	
	

	
	
	msgaddress.innerHTML="";    
	if(isBlank(address))
	  {msgaddress.innerHTML="<img src=pic/wrong.png>";
	  b.disabled=true;
	  free.disabled=true;
	   }
	else
	{
		contact.disabled=false;	
	}
	

	
	
	
	
	


}

























function valiMobile()
{
	
	
	var b=document.getElementById("b");
	var free=document.getElementById("free");

	var contact=document.getElementById("mobileno");
	var msgcontact=document.getElementById("msgmobileno");
	
	var email=document.getElementById("email");
	

	msgcontact.innerHTML=""; 
	if(isBlank(contact))
	{
		 
		  msgcontact.innerHTML="<img src=pic/wrong.png>";
		  b.disabled=true; 
		  free.disabled=true;
	}
	else if(!isBlank(contact))
	{
	  if(isDigit(contact))
	  { 
		 if(!checkMobile(contact))
	 	 {
	 	   
		   msgcontact.innerHTML="<font color=red><b><i>Mobile No Must Be 10 Digits..</b></i></font>";
		   b.disabled=true;
		   free.disabled=true;
	 	 }
		 else
			{
				email.disabled=false;	
			}
	  }
	  else
	 	{
	 	
		    msgcontact.innerHTML="<font color=red><b><i>Allow Only Digits..</b></i></font>";
		    
		    b.disabled=true;
		    free.disabled=true;
	 	}
	}
	
	
	
	
	
	
	
	
	
}





function valiEmail()
{
	var b=document.getElementById("b");
	var free=document.getElementById("free");
	var emailid=document.getElementById("email");
	var msgemailid=document.getElementById("msgemail");
	
	msgemailid.innerHTML="";    
	if(isBlank(emailid))
	  {msgemailid.innerHTML="<img src=pic/wrong.png>";
	  b.disabled=true;
	  free.disabled=true;
	   }
	else
	{
		
		b.disabled=false;
		free.disabled=false;
		
	}
}



////////////////////