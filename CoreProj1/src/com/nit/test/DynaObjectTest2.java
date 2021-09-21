package com.nit.test;

import java.lang.reflect.Constructor;

public class DynaObjectTest2 {

	public static void main(String[] args) {
		try {
			//Load java class
			Class c = Class.forName(args[0]);
			
			//Get all constructors of the class
			Constructor cons[] = c.getDeclaredConstructors();
			
			//Object creation using 0-param constructor
			Object obj1=cons[0].newInstance();
			System.out.println("Data of obj1: "+obj1);
			System.out.println("---------------------------");
			
			//Object creation using 2-param constructor
			Object obj2=cons[1].newInstance(45,88);
			System.out.println("Data of obj2: "+obj2);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
