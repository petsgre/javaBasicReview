package javaBasicReview;

import callBack.CallBack;
import callBack.Client;

public class Main {

	public static void main(String[] args) {
//		new Test().play();
		// 通过hibernate连接数据库
//		new DataBase().play();
		// 通过接口显现java回调函数
		CallBack callback = new CallBack();
		Client client = new Client();
		callback.setMyInterface(client);
		callback.play();
	}
}
