function isBlank(txt)
{  
	if(txt.value.length==0)
	return(true);
	else
	return(false);	
}
function isDigit(txt)
{   var result=true;
	for(var i=0;i<txt.value.length;i++)
	{ c=txt.value.charCodeAt(i);
	  if(!(c>=48 && c<=57))
		  {
		  result=false;
		  break;
		  }
		}
return(result);
}

function isAlpha(txt)
{   var result=true;
  
for(var i=0;i<txt.value.length;i++)
	{ c=txt.value.charCodeAt(i);
       
	if(!((c>=65 && c<=91)||(c>=97 && c<=122)||(c==32)))
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
		return(false);
		else
		return(true);	
}

function chkSubmit()
{ 
var result=true;
  var aid=document.getElementById("aid");
  var maid=document.getElementById("maid");
  maid.innerHTML="";
  var an=document.getElementById("an");
  var man=document.getElementById("man");
  man.innerHTML="";
  var ac=document.getElementById("ac");
  var mac=document.getElementById("mac");
  mac.innerHTML="";
  var ae=document.getElementById("ae");
  var mae=document.getElementById("mae");
  mae.innerHTML=""; 


   if(isBlank(aid))
    {
	  result=false;
	  maid.innerHTML="<font color=red>Admin ID Should Not Blank.</font>";
    }
   
   if(isBlank(an))
   {
	  result=false;
	  man.innerHTML="<font color=red>Name Should Not Blank.</font>";
   }
   else if(!isBlank(an))
	   {
	    if(!isAlpha(an))
	    	{result=false;
	  	  man.innerHTML="<font color=red>Allow Only Alphabets.</font>";
	    	
	    	}
	   }
  
   
   if(isBlank(ac))
   {
	  result=false;
	  mac.innerHTML="<font color=red>Contact Should Not Blank.</font>";
   }
   else if(!isBlank(ac))
   {
    if(checkMobile(ac))
    	{ if(!isDigit(ac))
    		{
    	result=false;
  	    mac.innerHTML="<font color=red>Allow Only Digits..</font>";
    		}
    	}
    else
    	{
    	result=false;
  	    mac.innerHTML="<font color=red>Mobile No Must Be 10 Digits..</font>";
    	
    	}
   }
   
   
	
   if(isBlank(ae))
   {
	  result=false;
	  mae.innerHTML="<font color=red>Email Id Should Not Blank.</font>";
   }
   return(result);
}



