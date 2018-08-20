package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class test {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs = null;
		try {
			// 反射加载sql驱动
			 Class.forName("com.mysql.jdbc.Driver");
			// 获得一个客户端
	    	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_001?characterEncoding=utf-8", "root", "root");
			// 预加载sql语句
			ps = conn.prepareStatement("update student set age=21 where name='rose'");
			ps2 = conn.prepareStatement("update student set age=28 where name='jock'");
			ps3 = conn.prepareStatement("select * from student");
			// 设置自动提交事务为false；//手动提交
			conn.setAutoCommit(true);
			// 提交预加载sql语句
			ps.executeUpdate();
			ps2.executeUpdate();
			 conn.rollback();
			// 提交事务
			conn.commit();
			rs = ps3.executeQuery();
			while (rs.next()) {
				int age = rs.getInt("age");
				String name = rs.getString("name");
				System.out.println("age ：" + age + " name " + name);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				ps.close();
				ps2.close();
				ps3.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
	}
}
