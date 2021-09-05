	function validate(frm) {
		//Read form data
		let name = frm.pname.value;
		let addrs = frm.paddrs.value;
		let age = frm.page.value;

		//Empty the form validations error msg
		document.getElementById("pnameErr").innerHTML = "";
		document.getElementById("paddrsErr").innerHTML = "";
		document.getElementById("pageErr").innerHTML = "";

		//Client side form validations
		let flag = true;
		if (name == "") { //Required rule on person name
			document.getElementById("pnameErr").innerHTML = "Person name is required";
			frm.pname.focus();
			flag = false;
		}
		if (addrs == "") { //Required rule on person address
			document.getElementById("paddrsErr").innerHTML = "Person address is required";
			frm.paddrs.focus();
			flag = false;
		} else if (addrs.length < 10) { //Min length rule on person address
			document.getElementById("paddrsErr").innerHTML = "Person address must have min of 10 chars";
			frm.paddrs.focus(); //Makes text box gaining the focus(cursor goes there)
			flag = false;
		}
		if (age == "") { //Required rule on person age
			document.getElementById("pageErr").innerHTML = "Person age is required";
			frm.page.focus();
			flag = false;
		} else if (isNaN(age)) { //Must be numeric value rule on person age
			document.getElementById("pageErr").innerHTML = "Person age must be numeric value";
			frm.page.focus();
			flag = false;
		} else if (age<=0 || age>125) {
			document.getElementById("pageErr").innerHTML = "Person age be there between 1 through 125";
			frm.page.focus();
			flag = false;
		}
		//Change hidden box value(vflag) to "yes" indicating client side form validations are done
		frm.vflag.value="yes";		
		return flag;
	}//function