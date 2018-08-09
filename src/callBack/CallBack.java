package callBack;

import util.Util;

public class CallBack {

	private MyInterface myInterface;
	public void play() {
		// TODO Auto-generated method stub
	Util.print("本身的逻辑，之后执行回调函数");
	int a = 1;
		myInterface.print(a);
	}
	public MyInterface getMyInterface() {
		return myInterface;
	}
	public void setMyInterface(MyInterface myInterface) {
		this.myInterface = myInterface;
	}
}
