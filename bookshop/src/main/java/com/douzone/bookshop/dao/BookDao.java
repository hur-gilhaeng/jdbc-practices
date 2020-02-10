package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.BookVo;

public class BookDao {
	
	public List<BookVo> allSelect(){
		ResultSet rs = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		List<BookVo> result = new ArrayList<BookVo>();

		try {
			conn = getConnection();
			String sql =  " select b.book_no, b.book_title, b.book_price, "+ 
						  "        b.category_no, c.category_name " + 
					      "   from book b"+
						  "   join category c on b.category_no = c.category_no";
			pstmt = conn.prepareStatement(sql); 

			rs = pstmt.executeQuery(); 

			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				Long categoryNo = rs.getLong(4);
				String categoryName = rs.getString(5);
				
				BookVo vo = new BookVo();
				vo.setBookNo(no);
				vo.setBookTitle(title);
				vo.setBookPrice(price);
				vo.setCategoryNo(categoryNo);
				vo.setCategoryName(categoryName);
				
				result.add(vo);
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

	public Boolean insert(BookVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into book value(null, ?, ?, ? )";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBookTitle());
			pstmt.setInt(2, vo.getBookPrice());
			pstmt.setLong(3, vo.getCategoryNo());

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
