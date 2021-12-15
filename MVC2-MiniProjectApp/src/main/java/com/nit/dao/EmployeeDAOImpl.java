package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nit.model.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";

	@Override
	public List<Employee> getEmpsByDesg(String desg) throws Exception{
		List<Employee> list = null;
		try(//Get Pooled Connection
				Connection con = getPooledConnection();
				//Create PreparedStatement object
				PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS)){
			//Set Query parameter value
			ps.setString(1, desg);

			//Execute the query
			try(ResultSet rs = ps.executeQuery()){
				//Convert RS object records to list of employee objects
				list = new ArrayList<>();
				while(rs.next()) {
					Employee e = new Employee();
					e.setEno(rs.getInt(1));
					e.setEname(rs.getString(2));
					e.setDesg(rs.getString(3));
					e.setSalary(rs.getFloat(4));
					list.add(e);
				}//while
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}//method

	//private method are taken as helper method
	private Connection getPooledConnection() throws Exception{
		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:/comp/env/DsJndi");
		return ds.getConnection();
	}
}//class