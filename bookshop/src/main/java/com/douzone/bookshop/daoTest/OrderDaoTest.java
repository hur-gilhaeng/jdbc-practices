package com.douzone.bookshop.daoTest;

import java.util.List;

import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		//insertTest();
		displayOrder();
	}
	public static void insertTest(){
		insertOrderTest("20200101-00001",1L,68000,"경기도 포천시 이동면");
		insertOrderBookTest("20200101-00001",2L,2);
		insertOrderBookTest("20200101-00001",3L,4);
	}
	public static void insertOrderTest(
			String orderNo, Long memberNo, int price, String orderAddr) {
		
		OrderVo vo = new OrderVo();
		
		vo.setOrderNo(orderNo);
		vo.setMemberNo(memberNo);
		vo.setOrderTotal(price);
		vo.setOrderAddr(orderAddr);
		
		new OrderDao().insertOrder(vo);
	}
	public static void insertOrderBookTest(
			String orderNo, Long bookNo, int bookAmount) {
		
		OrderBookVo vo = new OrderBookVo();
		
		vo.setOrderNo(orderNo);
		vo.setBookNo(bookNo);
		vo.setBookAmount(bookAmount);
		
		new OrderDao().insertOrderBook(vo);
	}
	
	public static void displayOrder() {
		List<OrderVo> list = new OrderDao().select();
		
		for(OrderVo vos : list) {
			System.out.println("주문번호: "+vos.getOrderNo()+
							   ", 주문자("+vos.getName()+
							   "/"+vos.getEmail()+
							   "), 결제금액: "+vos.getOrderTotal()+
							   "원, 배송지: "+vos.getOrderAddr());
			displayOrderBook(vos.getOrderNo());
		}
	}
	public static void displayOrderBook(String s) {
		List<OrderBookVo> list = new OrderDao().OrderBookSelect(s);
		
		for(OrderBookVo vos : list) {
			System.out.println("\t 도서 번호: "+vos.getBookNo()+
							   ", 도서 제목: "+vos.getBookTitle()+
		                       ", 수량: "+vos.getBookAmount());
		}
	}
}
