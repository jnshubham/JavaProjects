function isBlank(txt)
{  //alert(txt.value.length);
	if(txt.value.length==0)
 {return true;}
  else 
  {return false;}
}





function passwordmatch()
{var newpassword=document.getElementById("newpassword").value;
var cnewpassword=document.getElementById("cnewpassword").value;
var msgcnewpassword=document.getElementById("msgcnewpassword");
 
msgcnewpassword.innerHTML="";
if((newpassword.length || cnewpassword.length)!=0)
	{
if(newpassword==cnewpassword)
	{
	msgcnewpassword.innerHTML="<font color=green><b>Password Matched</b></font>";
	return true;
	}
else
	{
	msgcnewpassword.innerHTML="<font color=red><b>Password Not Matched</b></font>";
	return false;

	
	}
	}
	
}


















function validate()
{
	
	var result=true;
	
	   
	var oldpassword=document.getElementById("oldpassword");
	var msgoldpassword=document.getElementById("msgoldpassword");
	
	var newpassword=document.getElementById("newpassword");
	var msgnewpassword=document.getElementById("msgnewpassword");
	
	var cnewpassword=document.getElementById("cnewpassword");
	var msgcnewpassword=document.getElementById("msgcnewpassword");
	
	
	
	
	
	
	
	msgoldpassword.innerHTML=""; 
	if(isBlank(oldpassword))
	{msgoldpassword.innerHTML="<img src=pic/wrong.png>";
	result=false;
	 }
	
	
	
	
	
	msgcnewpassword.innerHTML="";    
	if(isBlank(cnewpassword))
	  {msgcnewpassword.innerHTML="<img src=pic/wrong.png>";
	  result=false;
	   }

	
		
		
	
	
	msgnewpassword.innerHTML="";    
	if(isBlank(newpassword))
	  {msgnewpassword.innerHTML="<img src=pic/wrong.png>";
	  result=false;
	   }
	if(!passwordmatch())
	{result=false;}
	
	
	//alert(result);
 return result;
}