function validate(frm){
	//Read form data
	let name = frm.pname.value;
	let age = frm.page.value;
	
	//Empty the form validations error msg
	document.getElementById("pnameErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	
	//Client side form validations
	let flag = true;
	if(name==""){  //required rule on person name
		document.getElementById("pnameErr").innerHTML="Person name is required";
		frm.pname.focus();
		flag=false;
	}
	if(age==""){  //required rule on person age
		document.getElementById("pageErr").innerHTML="Person age is required";
		frm.page.focus();
		flag=false;
	}
	else if(isNan(age)){  //Must be numeric value on person age
		document.getElementById("pageErr").innerHTML="Person age must be numeric value";
		frm.page.focus();
		flag=false;
	}
	else if(age<=0 || age>125){  //Person age be there between 1 through 125
		document.getElementById("pageErr").innerHTML="Person age be there between 1 through 125";
		frm.page.focus();
		flag=false;
	}
	//Change hidden box value(vflag) to "yes" indicating client side form validations are done
	frm.vflag.value="yes";
	return flag;
}//function