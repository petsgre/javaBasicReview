package javaBasicReview;

import java.awt.List;
import java.util.ArrayList;

import util.Util;

public class Test {
	public void play() {
		System.out.println("dayin");
		System.out.println("1");
		String a = new String("2asd");
		try {
			System.out.println(Integer.parseInt(a));
		} catch (Exception e) {
			System.out.println("不是数字，不能转成int");
			List list = new List();
			list.add("list的项目");
			ArrayList<String> arr = new ArrayList<String>();
			arr.add("arrarylist第一项");
			System.out.println(arr.get(0));
			int num = 100;
			System.out.println(new Util().totoString(num));
			try {
				System.out.println(list.getItem(0));

			} catch (Exception e2) {
				print("数组越界", 1);
			}
			// sum(1,2);
			// sum(100,2);
			for (int x = 0; x < 10; x++) {
				// sum(x,10000);
				// print(null,sum(x,10000));
				print(Util.tototoString(sum(x, 10000)), x);
				// System.out.println(sum(x,10000));

			}
		}
	}

	private static int sum(int a, int b) {
		return a + b;

	}

	public static void print(String str, int num) {
		if (str == null) {

			System.out.println(num);
		} else {

			System.out.println(str);
		}
	}
}
