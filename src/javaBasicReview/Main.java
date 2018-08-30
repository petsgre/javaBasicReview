package javaBasicReview;

import java.io.IOException;

import callBack.CallBack;
import callBack.Client;

public class Main {

	public static void main(String[] args) {
//		new Test().play();
		// 通过hibernate连接数据库
//		new DataBase().play();
		// 通过接口显现java回调函数
//		CallBack callback = new CallBack();
//		Client client = new Client();
//		callback.setMyInterface(client);
//		callback.play();
//		int a = 1001;
//		System.out.println((float)a/1000);
//		try {
//			new MyFile().play();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Ticket ticket  = new Ticket();
		Thread td1 = new Thread(ticket);
		Thread td2 = new Thread(ticket,"窗口2");
		Thread td3 = new Thread(ticket,"窗口3");
		td1.setName("窗口1");
		System.out.println(td1.getPriority());
		System.out.println(td2.getPriority());
		System.out.println(td3.getPriority());
		td1.start();
		td2.start();
		td3.start();
	}
}
