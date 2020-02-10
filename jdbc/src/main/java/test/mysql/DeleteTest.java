package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		Boolean result = delete(4L);
		if(result) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}

	}
	
	public static boolean delete(Long no) {
		Boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 1. JDBC Driver(MySQL) 로딩
			Class.forName("com.mysql.jdbc.Driver"); 
			// 클래스의 위치는 mysql-connector-java.5.1.38.jar에 위치함 
			// 따라서 라이브러리를 지정하지 않으면 드라이버 로딩이 실패한다!

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb");

			// 3.Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4. SQL문 실행 
			String sql = "delete from dept where no = "+ no;
			int count = stmt.executeUpdate(sql);
			result = count==1;
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패:"+e);
			// e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error:"+e);
			// e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
