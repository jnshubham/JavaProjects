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



////////////////////////////////

function chkdishname()
{
	var dishname=document.getElementById("dishname");
 	var msgdishname=document.getElementById("msgdishname");
 	
 	
 	msgdishname.innerHTML="";
 	if(!isAlpha(dishname))
 	{
 		msgdishname.innerHTML="<img src=pic/wrong.png>";
 		return false;
 	}
 	else
 	{
 		msgdishname.innerHTML="<img src=pic/correct.png>";	
 		return true;
 	}


}



function chkDescription()
{
	
	var description=document.getElementById("description");
 	var msgdescription=document.getElementById("msgdescription");
 	
 	
 
 		msgdescription.innerHTML="";
 	 	if(isDigit(description))
 	 	{
 	 		msgdescription.innerHTML="<img src=pic/wrong.png>";
 	 		return false;
 	 	}
 	 	else
 	 	{	
 	 		msgdescription.innerHTML="<img src=pic/correct.png>";
 	 		return true;
 	 	}
 		
}






/////////////////////////////////

function validation()
{
	
 	//alert(1);
 	result=true;
 	var menu=document.getElementById("menu");
 	var msgmenu=document.getElementById("msgmenu");
 	
	var dishname=document.getElementById("dishname");
 	var msgdishname=document.getElementById("msgdishname");
 	
 	var description=document.getElementById("description");
 	var msgdescription=document.getElementById("msgdescription");
 	
 	var icon=document.getElementById("icon");
 	var msgicon=document.getElementById("msgicon");
 	
 	var price=document.getElementById("price");
 	var msgprice=document.getElementById("msgprice");
 	
 	var specialoffer=document.getElementById("specialoffer");
 	var msgspecialoffer=document.getElementById("msgspecialoffer");
 	
 	
 	
 	
 	
//////////////For Menu Name //////////////
    
    msgmenu.innerHTML="";
 	if(isBlank(menu))
 	{
 		msgmenu.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		msgmenu.innerHTML="<img src=pic/correct.png>";
 	}
 	
 	
 	
 	
 		
 	
 	
 	
//////////////For Dish Name //////////////
 	
 	msgdishname.innerHTML="";
    if(!isBlank(dishname))
 	{
 		if(!chkdishname())
 		{
 			msgdishname.innerHTML="<img src=pic/wrong.png>";
 			result=false;
 		}
 		else
 		{
 			msgdishname.innerHTML="<img src=pic/correct.png>";
 		}
 		
	}
 	else
 	{
 		msgdishname.innerHTML="<img src=pic/wrong.png>";
 		result=false; 	
 	}
 	
 	
 	
 	
    
//////////////For Description //////////////
 	
    msgdescription.innerHTML="";
    if(!isBlank(description))
 	{
 		if(!chkDescription())
 		{
 			msgdescription.innerHTML="<img src=pic/wrong.png>";
 			result=false;	
 		}
 		else
 		{
 			msgdescription.innerHTML="<img src=pic/correct.png>";	
 		}
 		
 		
 	}
 	else
 	{
 		
 		msgdescription.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	 	
 	}
    
    
    
    
//////////////For Icon //////////////
    
    msgicon.innerHTML="";
 	if(isBlank(icon))
 	{
 		msgicon.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		msgicon.innerHTML="<img src=pic/correct.png>";
 	}
 	
 	
 	
 	
 	
//////////////For Price //////////////
 	
 	msgprice.innerHTML="";
 	if(isBlank(price))
 	{
 		msgprice.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else if(!isBlank(price))
	{
	  if(isDigit(price))
	  { 
		  msgprice.innerHTML="<img src=pic/correct.png>";
	  }
	  else
	  {
		msgprice.innerHTML="<font color=red><b><i>Allow Only Digits..</b></i></font>";
		result=false;
	  }
	  
	}
 	
 	
 	
 	
//////////////For Special Offer //////////////
 	
 	msgspecialoffer.innerHTML="";
 	if(isBlank(specialoffer))
 	{
 		msgspecialoffer.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else if(!isBlank(specialoffer))
	{
	  if(isDigit(specialoffer))
	  { 
		  msgspecialoffer.innerHTML="<img src=pic/correct.png>";
	  }
	  else
	  {
		msgspecialoffer.innerHTML="<font color=red><b><i>Allow Only Digits..</b></i></font>";
		result=false;
	  }
	  
	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	return result;
}