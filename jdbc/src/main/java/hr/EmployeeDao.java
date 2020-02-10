package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public Boolean insert(EmployeeVo vo) {
		return false;
	}

	public Boolean delete(Long no) {
		return false;
	}

	public Boolean delete(String a) {
		return false;
	}

	public Boolean update(EmployeeVo vo) {
		return false;
	}

	public List<EmployeeVo> findByName(EmployeeVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<EmployeeVo> result = new ArrayList<EmployeeVo>();
		
		try {
			// 1. JDBC Driver(MySQL) 로딩
			Class.forName("com.mysql.jdbc.Driver");
			// 클래스의 위치는 mysql-connector-java.5.1.38.jar에 위치함
			// 따라서 라이브러리를 지정하지 않으면 드라이버 로딩이 실패한다!

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. SQL문 준비(PrePare, 완성된 쿼리가 아님)
			String sql =  "  select emp_no, first_name, last_name, hire_date " + 
						  "    from employees " + 
					      "   where first_name like ? " + 
					      " order by first_name ";
			pstmt = conn.prepareStatement(sql); // sql삽입;
			
			// 4. 바인딩
			pstmt.setString(1,"%"+vo.getFirstName()+"%");
			
			// 5. SQL문 실행
			rs = pstmt.executeQuery(); // 여기엔 sql을 집어 넣지 않는다!!!
			
			// 6. 결과 바인딩
			while (rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String hireDate = rs.getString(4);
				
				EmployeeVo employeeVo = new EmployeeVo();
				employeeVo.setNo(no);
				employeeVo.setFirstName(firstName);
				employeeVo.setLastName(lastName);
				employeeVo.setHireDate(hireDate);
				
				result.add(employeeVo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패:" + e);
			// e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error:" + e);
			// e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
