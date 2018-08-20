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
			// �������sql����
			 Class.forName("com.mysql.jdbc.Driver");
			// ���һ���ͻ���
	    	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_001?characterEncoding=utf-8", "root", "root");
			// Ԥ����sql���
			ps = conn.prepareStatement("update student set age=21 where name='rose'");
			ps2 = conn.prepareStatement("update student set age=28 where name='jock'");
			ps3 = conn.prepareStatement("select * from student");
			// �����Զ��ύ����Ϊfalse��//�ֶ��ύ
			conn.setAutoCommit(true);
			// �ύԤ����sql���
			ps.executeUpdate();
			ps2.executeUpdate();
			 conn.rollback();
			// �ύ����
			conn.commit();
			rs = ps3.executeQuery();
			while (rs.next()) {
				int age = rs.getInt("age");
				String name = rs.getString("name");
				System.out.println("age ��" + age + " name " + name);
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
