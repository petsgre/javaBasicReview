package javaBasicReview;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;

import util.Util;

public class MyFile {

	public void play() throws IOException {
		String ss = null;
		ss+="123";
//		System.out.println(ss);
		// TODO Auto-generated method stub
		File file = new File("\\Users\\administrator\\zx\\111.html");
		if (!file.exists()) {
			try {
				Util.print(file.createNewFile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File f = new File("111.html");

		FileInputStream fi = new FileInputStream(f);
		InputStreamReader ir = new InputStreamReader(fi, "utf-8");
//		StringBuffer sb = new StringBuffer();
		String sb = "";
		while (ir.ready()) {
//			sb.append((char) ir.read());
			// 转成char加到StringBuffer对象中
			sb+= (char)ir.read();
		}
		ir.close();
		fi.close();
//		Util.print(sb);

		FileOutputStream fop = new FileOutputStream(f);
		// 构建FileOutputStream对象,文件不存在会自动新建

		OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
		// 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

		writer.append("<html><head></head><body>123321"

				+ "</body></html>");
		// 写入到缓冲区

		// writer.append("\r\n");
		// 换行

		// writer.append("English");
		// 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

		writer.close();
		// 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

		fop.close();
		// 关闭输出流,释放系统资源

		 FileInputStream fip = new FileInputStream(f);
		 // 构建FileInputStream对象
		
		 InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
		 // 构建InputStreamReader对象,编码与写入相同
		
		 StringBuffer sb1 = new StringBuffer();
		 while (reader.ready()) {
		 sb1.append((char) reader.read());
		 // 转成char加到StringBuffer对象中
		 }
//		 System.out.println(sb1.toString());
		 reader.close();
		 // 关闭读取流
		
		 fip.close();
		// 关闭输入流,释放系统资源
		 video();
	}

	private void video() throws FileNotFoundException {
		//读取文件
		File file = new File("asd.mp4");
//		File file = new File("test.txt");
		FileInputStream fis = new FileInputStream(file);
		File outFile = new File("new.mp4");
//		File outFile = new File("test1.txt");
		FileOutputStream fos = new FileOutputStream(outFile); 
		try {
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			try {
				byte[] b = new byte[1024];
				int num = bis.read(b);
				Calendar startcalendar = Calendar.getInstance();
				long start = startcalendar.getTimeInMillis();
				while(num!=-1) {
					System.out.println(num);
					bos.write(b,0,num);
					num = bis.read(b);
				}
				bis.close();
				bos.close();
				Calendar endcalendar = Calendar.getInstance();
				long end = endcalendar.getTimeInMillis();

				
				System.out.println("******");
				System.out.println((float)(end-start)/1000+"s");
				System.out.println("复制完成");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
