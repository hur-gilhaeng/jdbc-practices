package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CartVo;

public class CartDao {
	
	public List<CartVo> allSelect(){
		ResultSet rs = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		List<CartVo> result = new ArrayList<CartVo>();

		try {
			conn = getConnection();
			String sql =  "   select c.member_no, c.book_no, c.book_amount, "+ 
						  "          b.book_price, b.book_title " + 
					      "     from cart c"+
						  "     join book b on b.book_no = c.book_no"+
					      " order by c.member_no asc ";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(); 

			while (rs.next()) {
				Long meberNo = rs.getLong(1);
				Long bookNo = rs.getLong(2);
				int bookAmount = rs.getInt(3);
				int price = (rs.getInt(4) * bookAmount);
				String bookTitle = rs.getString(5);
				
				CartVo vo = new CartVo();
				vo.setMeberNo(meberNo);
				vo.setBookNo(bookNo);
				vo.setBookAmount(bookAmount);
				vo.setPrice(price);
				vo.setBookTitle(bookTitle);
				
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
	}

	public Boolean insert(CartVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into cart value( ?, ?, ? )";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getMeberNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getBookAmount());

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
