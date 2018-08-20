package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc {
     public static void main(String[] args) throws Exception {
    	 Connection connection = null;
    	 PreparedStatement preparedStatement = null;
    	 ResultSet resultSet = null;
    	 Class.forName("com.mysql.jdbc.Driver");
    	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_001?characterEncoding=utf-8", "root", "root");
    	 String sql = "select * from user";
    	 preparedStatement = connection.prepareStatement(sql);
    	 resultSet = preparedStatement.executeQuery();
    	 while(resultSet.next()) {
    		 System.out.println(resultSet.getString("name") + " " + resultSet.getString("address"));
    	 }
    	 
    	 connection.close();
    	 preparedStatement.close();
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
          /*// ���ݿ�����
          Connection connection = null;
          // Ԥ�����Statement��ʹ��Ԥ�����Statement������ݿ�����
          PreparedStatement preparedStatement = null;
          // ��� ��
          ResultSet resultSet = null;

          try {
              // �������ݿ�����
              Class.forName("com.mysql.jdbc.Driver");

              // ͨ�������������ȡ���ݿ�����
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_001?characterEncoding=utf-8",
                    "root", "root");
              // ����sql��� ?��ʾռλ��
              String sql = "select * from user where username = ?";
              // ��ȡԤ����statement
              preparedStatement = connection.prepareStatement(sql);
              // ���ò�������һ������Ϊsql����в�������ţ���1��ʼ�����ڶ�������Ϊ���õĲ���ֵ
              preparedStatement.setString(1, "����");
              // �����ݿⷢ��sqlִ�в�ѯ����ѯ�������
              resultSet = preparedStatement.executeQuery();
              // ������ѯ�����
              while (resultSet.next()) {
                   System.out.println(resultSet.getString("id") + "  " + resultSet.getString("username"));
              }
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              // �ͷ���Դ
              if (resultSet != null) {
                   try {
                        resultSet.close();
                   } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                   }
              }
              if (preparedStatement != null) {
                   try {
                        preparedStatement.close();
                   } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                   }
              }
              if (connection != null) {
                   try {
                        connection.close();
                   } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                   }
              }
          }*/
     }
}