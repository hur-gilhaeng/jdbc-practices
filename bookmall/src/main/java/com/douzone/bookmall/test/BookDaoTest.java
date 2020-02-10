package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;

import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insertTest("트와일라잇",1L);
//		insertTest("뉴문",1L);
//		insertTest("이클립스",1L);
//		insertTest("브레이킹던",1L);
//		insertTest("아리랑",2L);
//		insertTest("젊은그들",3L);
//		insertTest("아프니까 청춘이다",4L);
//		insertTest("귀천",5L);
//		insertTest("태백산맥",2L);
//		insertTest("풀하우스",6L);
//		
//		selectTest();
//		
//		System.out.println();
//
//		
//		updateTest("풀하우스", "대여중");
		selectTest();
	}

	private static void insertTest(String title, Long authorNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setAuthorNo(authorNo);
		new BookDao().insert(vo);
	}

	private static void deleteTest(String title) {
		BookDao dao = new BookDao();
		dao.delete(title);
	}

	private static void deleteTest(Long no) {
		BookDao dao = new BookDao();
		dao.delete(no);
	}

	private static void updateTest(String title, Long no) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setNo(no);
		new BookDao().titleUpdate(vo);
	}

	private static void updateTest(String title, String state) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setState(state);
		new BookDao().update(vo);
	}

	private static void selectTest() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.select();

		for (BookVo vos : list) {
			System.out.println(vos);
		}
	}
}
