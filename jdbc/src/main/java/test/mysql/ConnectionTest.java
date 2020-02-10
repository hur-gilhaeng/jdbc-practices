package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// 1. JDBC Driver(MySQL) 로딩
			Class.forName("com.mysql.jdbc.Driver"); 
			// 클래스의 위치는 mysql-connector-java.5.1.38.jar에 위치함 
			// 따라서 라이브러리를 지정하지 않으면 드라이버 로딩이 실패한다!

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			connection = DriverManager.getConnection(url,"webdb","webdb");

			System.out.println("연결성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패:"+e);
			// e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error:"+e);
			// e.printStackTrace();
		} finally {
			// 3. 자원정리
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
}
