package com.douzone.bookshop.daoTest;

import java.util.List;

import com.douzone.bookshop.dao.BookDao;
import com.douzone.bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//insertTest();
		displayBook();
	}
	public static void insertTest(){
		insertBookTest("위저드 베이커리",12000,1L);
		insertBookTest("이것이 자바다",32000,2L);
		insertBookTest("도시는 무엇으로 사는가",20000,3L);
	}
	
	public static void displayBook() {
		List<BookVo> list = new BookDao().allSelect();
		
		for(BookVo vos : list) {
			System.out.println("도서 분류: "+vos.getCategoryName()+
							   ", 도서명: "+vos.getBookTitle()+
							   ", 가격: "+vos.getBookPrice()+"원");
		}
	}
	
	public static void insertBookTest(String title,int price, Long categoryNo) {
		BookVo vo = new BookVo();
		
		vo.setBookTitle(title);
		vo.setBookPrice(price);
		vo.setCategoryNo(categoryNo);
		
		new BookDao().insert(vo);
	}

}
