package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDao {
	
	public List<OrderVo> select(){
		ResultSet rs = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		List<OrderVo> result = new ArrayList<OrderVo>();

		try {
			conn = getConnection();
			String sql =  " select o.order_no, o.order_total, o.order_addr,"+
						  "        m.member_no, m.name, m.email"+  
					      "   from orders o, member m"+
						  "  where o.member_no = m.member_no";
			pstmt = conn.prepareStatement(sql); 

			rs = pstmt.executeQuery(); 

			while (rs.next()) {
				String orderNo = rs.getString(1);
				int orderTotal = rs.getInt(2);
				String orderAddr = rs.getString(3);
				
				Long memberNo = rs.getLong(4);
				String name = rs.getString(5);
				String email = rs.getString(6);
				
				OrderVo vo = new OrderVo();
				vo.setOrderNo(orderNo);
				vo.setOrderTotal(orderTotal);
				vo.setOrderAddr(orderAddr);
				
				vo.setMemberNo(memberNo);
				vo.setName(name);
				vo.setEmail(email);
				
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
	
	public List<OrderBookVo> OrderBookSelect(String no) {
		ResultSet rs = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		List<OrderBookVo> result = new ArrayList<OrderBookVo>();

		try {
			conn = getConnection();
			String sql =  " select ob.order_no, ob.book_amount,"+
						  "        b.book_no, b.book_title"+  
					      "   from order_book ob, book b"+
						  "  where ob.book_no = b.book_no"+
					      "    and ob.order_no = ? ";
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, no);

			rs = pstmt.executeQuery(); 

			while (rs.next()) {
				String orderNo = rs.getString(1);
				int bookAmount = rs.getInt(2);
				
				Long bookNo = rs.getLong(3);
				String bookTitle = rs.getString(4);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setOrderNo(orderNo);
				vo.setBookAmount(bookAmount);
				vo.setBookNo(bookNo);
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

	public Boolean insertOrder(OrderVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into orders value(?, ?, ?, ? )";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getOrderNo());
			pstmt.setLong(2, vo.getMemberNo());
			pstmt.setInt(3, vo.getOrderTotal());
			pstmt.setString(4, vo.getOrderAddr());

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
	
	public Boolean insertOrderBook(OrderBookVo vo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into order_book value( ?, ?, ? )";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getOrderNo());
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
