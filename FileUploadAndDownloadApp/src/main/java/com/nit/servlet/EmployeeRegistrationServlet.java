package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class EmployeeRegistrationServlet extends HttpServlet{
	private static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO UPLOAD_EMPLOYEE VALUES(EMPNO_SEQ.NEXTVAL,?,?,?,?)";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter Object
		PrintWriter pw = res.getWriter();

		//Set response content type
		res.setContentType("text/html");

		Connection con = null;
		PreparedStatement ps = null;

		try {
			//Create Special Request object
			MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);

			//Read form data
			String name = nreq.getParameter("ename");
			String addrs = nreq.getParameter("eadd");
			//Create UploadBean class object
			UploadBean upb = new UploadBean();
			upb.setFolderstore("E:/Deepak/Classcontent/Store");  //folder location in the server machine file location
			upb.setOverwrite(false);
			upb.setFilesizelimit(50*1024);
			//Complete file upload process
			upb.store(nreq);
			pw.println("<h1 style='color:green;text-align:center'><b>Files are uploaded successfully</b></h1>");

			//Get the names of the uploaded files
			Vector <UploadParameters> vector = upb.getHistory();
			ArrayList<String> fileList = new ArrayList();
			vector.forEach(up->{
				fileList.add("E:/Deepak/Classcontent/Store/"+up.getFilename());
			});
			//Write JDBC code to form data and files location of db table as record
			//Load JDBC driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//Create PreparedStatement object
			ps = con.prepareStatement(INSERT_EMPLOYEE_QUERY);
			//Set values to query params
			ps.setString(1, name);
			ps.setString(2, addrs);
			ps.setString(3, fileList.get(1));
			ps.setString(4, fileList.get(0));
			//Execute the query
			int count = ps.executeUpdate();
			if(count==1)
				pw.println("<h1 style='color:green;text-align:center'>Employee is registered</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Employee is not registered</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			pw.println("<br><h2 style='color:red;text-align:center'><b>Problem in file uploading</b></h2>");
		}
		finally {
			//Close JDBC objects
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally

		//Add home hyperlink
		pw.println("<h1 style='text-align:center'><a href='index.html'>Home</a></h1>");

		//Close stream
		pw.close();
	}//doGet(-,-)

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class