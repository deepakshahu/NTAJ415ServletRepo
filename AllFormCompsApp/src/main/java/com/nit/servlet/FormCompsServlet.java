package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formurl")
public class FormCompsServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw = res.getWriter();

		//Set response content type
		res.setContentType("text/html");

		//Read form data
		String name = req.getParameter("pname");
		int age = Integer.parseInt(req.getParameter("page"));
		String address = req.getParameter("paddrs");
		String gender = req.getParameter("gender");
		String ms = req.getParameter("ms");
		ms=(ms==null)?"single":ms;
		String qlfy = req.getParameter("qlfy");
		String languages[] = req.getParameterValues("languages");
		if(languages==null)
			languages=new String[] {"No languages are selected"};
		
		String hobbies[] = req.getParameterValues("hb");
		if(hobbies==null)
			hobbies=new String[] {"No hobbies are selected"};
		
		String dob = req.getParameter("dob");
		String tob = req.getParameter("tob");
		String mob = req.getParameter("mob");
		String wdb = req.getParameter("wdb");
		int favNumber = Integer.parseInt(req.getParameter("favNumber"));
		long mobileNo = Long.parseLong(req.getParameter("mobileNo"));
		String mail = req.getParameter("mail");
		String favColor = req.getParameter("favColor");
		int income = Integer.parseInt(req.getParameter("income"));
		String fburl = req.getParameter("fburl");
		String favSS = req.getParameter("favSearch");

		//Write b.logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1 style='color:blue;text-align:center'>Master. "+name+" you are baby boy</h1>");
			else if(age<13)
				pw.println("<h1 style='color:blue;text-align:center'>Master. "+name+" you are small boy</h1>");
			else if(age<19)
				pw.println("<h1 style='color:blue;text-align:center'>Mr. "+name+" you are teenage boy</h1>");
			else if(age<35)
				pw.println("<h1 style='color:blue;text-align:center'>Mr. "+name+" you are young man</h1>");
			else if(age<50)
				pw.println("<h1 style='color:blue;text-align:center'>Mr. "+name+" you are a middle-aged man</h1>");
			else
				pw.println("<h1 style='color:blue;text-align:center'>Mr. "+name+" you are old man</h1>");
		}
		else {
			if(age<5)
				pw.println("<h1 style='color:blue;text-align:center'>Master. "+name+" you are baby girl</h1>");
			else if(age<13)
				pw.println("<h1 style='color:blue;text-align:center'>Master. "+name+" you are small girl</h1>");
			else if(age<19) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center'>Mrs. "+name+" you are teenage married girl</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center'>Miss. "+name+" you are teenage girl</h1>");
			}
			else if(age<35) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center'>Mrs. "+name+" you are young married girl</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center'>Miss. "+name+" you are young girl</h1>");
			}
			else if(age<50) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center'>Mrs. "+name+" you are middle-aged woman</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center'>Miss. "+name+" you are middle-aged woman</h1>");
			}
			else {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center'>Mrs. "+name+" you are a old woman</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center'>Miss. "+name+" you are a old woman</h1>");
			}//else
		}//else
		
		//Display the form data
		pw.println("<br><br><b>Form Data:</b><br>");
		pw.println("<br><b>Name: </b>"+name);
		pw.println("<br><b>Age: </b>"+age);
		pw.println("<br><b>Address: </b>"+address);
		pw.println("<br><b>Gender: </b>"+gender);
		pw.println("<br><b>Marital Status: </b>"+ms);
		pw.println("<br><b>Qualification: </b>"+qlfy);
		pw.println("<br><b>Languages Known: </b>"+Arrays.toString(languages));
		pw.println("<br><b>Hobbies: </b>"+Arrays.toString(hobbies));
		pw.println("<br><b>Date of Birth: </b>"+dob);
		pw.println("<br><b>Time of Birth: </b>"+tob);
		pw.println("<br><b>Month of Birth: </b>"+mob);
		pw.println("<br><b>Week Day of Birth: </b>"+wdb);
		pw.println("<br><b>Favourite Number: </b>"+favNumber);
		pw.println("<br><b>Mobile Number: </b>"+mobileNo);
		pw.println("<br><b>Email: </b>"+mail);
		pw.println("<br><b>Favourite Color: </b>"+favColor);
		pw.println("<br><b>Person Income: </b>"+income);
		pw.println("<br><b>FB URL: </b>"+fburl);
		pw.println("<br><b>Fav Google Search String: </b>"+favSS);
		
		//Add Home hyperlink
		pw.println("<br><br><a href='all_comps_form.html'>Home</a>");
		
		//Close stream
		pw.close();
	}//doGet(-,-)

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}//doPost(-,-)
}//class