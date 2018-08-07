package javaBasicReview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.ResultSetMetaData;

import myhibernate.Product;
import util.Util;

public class DataBase {
	public void play() {
		try {
			Connection con = createConn();
			String sql = "select * from categories";
			PreparedStatement st = con.prepareStatement(sql);
			// for (int i = 0; i < parameters.length; i++) {
			// st.setString(i+1,parameters[i]);
			// }
			ResultSet result = st.executeQuery();
			ArrayList<Object> list = new ArrayList<Object>();
			ResultSetMetaData md = (ResultSetMetaData) result.getMetaData(); // 获得结果集结构信息,元数据
			int columnCount = md.getColumnCount(); // 获得列数
			while (result.next()) {
				HashMap<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), result.getObject(i));
				}
				list.add(rowData);
			}
			Util.print(list.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getProduct();
	}

	public Connection createConn() throws ClassNotFoundException, SQLException {
		String driverName = "com.mysql.jdbc.Driver";
		String userName = "admin";
		String dbURL = "jdbc:mysql://localhost:6688/northwind?useUnicode=true&characterEncoding=GBK";
		String userPwd = "admin";

		Class.forName(driverName);

		return DriverManager.getConnection(dbURL, userName, userPwd);
	}

	public void getProduct() {
		Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession(); // 相当于得到一个Connection
		// 开启事务
		session.beginTransaction();

		// 根据业务来编写代码
		// Customer c = session.get(Customer.class, 1);
//		Product c = session.get(Product.class, 4);
		
		Query query = session.createQuery("from Product");
        //2、使用Query对象的list方法得到数据集合
        List<Product> list = query.list();

		System.out.println("*******");
		System.out.println(list.toString());

		// 事务提交
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
