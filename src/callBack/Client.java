package callBack;

import util.Util;

public class Client implements MyInterface {
	private int a = 20;
	public void print(int aa) {
		Util.print("回调函数执行:"+a+aa);
	}

}
