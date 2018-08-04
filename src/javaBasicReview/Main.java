package javaBasicReview;

import java.awt.List;
import java.sql.Array;
import java.util.ArrayList;

import util.Util;

public class Main {
	public static void print(String str) {
		System.out.println(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("dayin");
		System.out.println("1");
		String a = new String("2asd");
		try {
			System.out.println(Integer.parseInt(a));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("不是数字，不能转成int");
			List list  = new List();
			list.add("list的项目");
			ArrayList<String> arr = new ArrayList<String>();
			arr.add("arrarylist第一项");
			System.out.println(arr.get(0));
			int num = 100;
			System.out.println(new Util().totoString(num));
			try {
				System.out.println(list.getItem(1));
				
			} catch (Exception e2) {
				// TODO: handle exception
				print("数组越界");
				
			}
		}
	}
}
