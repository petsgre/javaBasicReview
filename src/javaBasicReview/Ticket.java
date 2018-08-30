package javaBasicReview;

import java.util.Calendar;

public class Ticket implements Runnable{
	public int num = 100;
	long start;
	Object mutex = new Object();
	public void run() {
		// TODO Auto-generated method stub
		while (num>0) {
			synchronized (mutex) {
				if(num<1) {
					return;
				}
				num--;
				System.out.println(Thread.currentThread().getName()+"卖了1张票，剩余"+num);
				if(num == 99) {
					Calendar startcalendar = Calendar.getInstance();
					start = startcalendar.getTimeInMillis();
				}
				if(num == 0) {
					Calendar endcalendar = Calendar.getInstance();
					long end = endcalendar.getTimeInMillis();
					System.out.println((float)(end-start)/1000+"s");
					System.out.println("卖完了");
				}
			}
//			if(Thread.currentThread().getName().equals("窗口1")) {
//				int pp = Thread.currentThread().getPriority();
//				pp = pp>1?pp-1:0;
////				System.out.println(pp);
//				if(pp<1) {
//					return;
//				}
//				try {
//					Thread.currentThread().setPriority(pp);
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
//			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
