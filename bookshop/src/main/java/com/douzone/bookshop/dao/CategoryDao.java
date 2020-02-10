package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CategoryVo;

public class CategoryDao {
	
	public List<CategoryVo> allSelect(){
		ResultSet rs = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		List<CategoryVo> result = new ArrayList<CategoryVo>();

		try {
			conn = getConnection();
			String sql =  " select category_no, category_name " + 
					      "   from category ";
			pstmt = conn.prepareStatement(sql); 

			rs = pstmt.executeQuery(); 

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				CategoryVo categoryVo = new CategoryVo();
				categoryVo.setCategoryNo(no);
				categoryVo.setCategoryName(name);
				
				result.add(categoryVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
	};

	public Boolean insert(CategoryVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into category value(null, ? )";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCategoryName());

			int count = pstmt.executeUpdate();
			result = count==1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	private Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			 
			return DriverManager.getConnection(url, "bookshop", "bookshop");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
