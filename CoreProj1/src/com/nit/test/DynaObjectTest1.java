package com.nit.test;

public class DynaObjectTest1 {

	public static void main(String[] args) {
		try {
			//Load java class
			Class c = Class.forName(args[0]);
			
			//Create dynamic object
			Object obj = c.newInstance();
			System.out.println(obj);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
