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



function isPhoto(txt)
{
	for(var i=0;i<txt.value.length;i++)
	{
		c=txt.value.charCodeAt(i);
		if(c==".")
		{
			var sc=txt.split(".");
			for(var i=0;i<sc.length-1;i++);
			
			var temp=sc[i];
			
			if(temp=="jpg" || temp=="JPEG" || temp=="png" || temp=="PNG")
			{
				
				return true;
				
			}
			return false;
			
		}
	  return false;
	}



}
////////////////////////////////

function chkmenuname()
{
	var menuname=document.getElementById("menuname");
 	var msgmenuname=document.getElementById("msgmenuname");
 	
 	msgmenuname.innerHTML="";
 	if(!isAlpha(menuname))
 	{
 		msgmenuname.innerHTML="<img src=pic/wrong.png>";
 		return false;
 	}
 	else
 		{
 		
 		msgmenuname.innerHTML="<img src=pic/correct.png>";
 		return true;
 		}


}



function chkDescription()
{
	
	var description=document.getElementById("description");
 	var msgdescription=document.getElementById("msgdescription");
 	
 	
 	msgdescription.innerHTML="";
 	if(isBlank(description))
 	{
 		msgdescription.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 		{
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
}




function checkPhoto()
{
	var icon=document.getElementById("icon");
 	var msgicon=document.getElementById("msgicon");
 	
 	
 	msgicon.innerHTML="";
    
 	if(isPhoto(icon))
 	{
 		msgdescription.innerHTML="<img src=pic/correct.png>";
	    return true;
 		
 	}
 	else
 	{
 		msgdescription.innerHTML="<img src=pic/wrong.png>";
 		return false;
 	 	
 	}

}






/////////////////////////////////

function validation()
{
	//alert(1);
	result=true;
	var hotel=document.getElementById("hotel");
 	var msghotel=document.getElementById("msghotel");
	
	var menuname=document.getElementById("menuname");
 	var msgmenuname=document.getElementById("msgmenuname");
	
 	var description=document.getElementById("description");
 	var msgdescription=document.getElementById("msgdescription");
 	
	var icon=document.getElementById("icon");
 	var msgicon=document.getElementById("msgicon");

 	
 	
//////////////For Hotel Name //////////////
 	msghotel.innerHTML="";
 	if(isBlank(hotel))
 	{
 		msghotel.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	
 	
 	
 	
 	
//////////////For Menu Name //////////////
 	 
 	msgmenuname.innerHTML="";
 	if(isBlank(menuname))
 	{
 		msgmenuname.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 	    if(chkmenuname())
 	    {
 	    	msgmenuname.innerHTML="<img src=pic/correct.png>";
 	    }
 	    else
 	    {
 	    	msgmenuname.innerHTML="<img src=pic/wrong.png>";
 	    	result=false;
 	    }
 	}
 		
 	
 	msgdescription.innerHTML="";
 	if(isBlank(description))
 	{
 		msgdescription.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		if(chkDescription())
 		{
 			msgdescription.innerHTML="<img src=pic/correct.png>";
 		}
 		else
 		{
 			msgdescription.innerHTML="<img src=pic/wrong.png>";
 			result=false;
 		}
 	}
 	
 	
 	msgicon.innerHTML="";
 	if(isBlank(icon))
 	{
 		msgicon.innerHTML="<img src=pic/wrong.png>";
 		result=false;
 	}
 	else
 	{
 		 checkPhoto();
 	}
 	
 	return false;
}