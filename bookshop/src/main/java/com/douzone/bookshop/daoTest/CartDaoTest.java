package com.douzone.bookshop.daoTest;

import java.util.List;

import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		//insertTest();
		displayCart();
	}
	
	public static void insertTest(){
		insertCartTest(1L, 1L, 3);
		insertCartTest(1L, 2L, 1);
	}
	
	public static void displayCart() {
		List<CartVo> list = new CartDao().allSelect();
		
		for(CartVo vos : list) {
			System.out.println(vos.getMeberNo()+"번 고객님 카트항목: "+
							   "도서명: "+vos.getBookTitle()+
							   ", 수량: "+vos.getBookAmount()+
							   ", 총 가격: "+vos.getPrice()+"원");
		}

	}
	
	public static void insertCartTest(Long meberNo, Long bookNo, int bookAmount) {
		CartVo vo = new CartVo();
	
		vo.setMeberNo(meberNo);
		vo.setBookNo(bookNo);
		vo.setBookAmount(bookAmount);
		
		new CartDao().insert(vo);
	}


}
