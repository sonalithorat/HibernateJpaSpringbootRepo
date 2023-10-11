package com.demo.HibernateDemo.repository;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static List<Integer> check(){
		
		List<Integer> list = new ArrayList<Integer>();
		try {
			list.add(1);
			return list;
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			list.add(3);
			return list;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(check());
		
		String s = "10.22";
		Double a = Double.parseDouble(s);
		System.out.println(a);

	}

}
