package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.AuthorDao;
import com.douzone.bookmall.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		
//		System.out.println("인서트!");
//		insertTest();
//		selectTest();
		
		System.out.println("업데이트!");
		updateTest();
		selectTest();
		
//		System.out.println("딜릭트!");
//		deleteTest_2();
//		selectTest();
	}

	private static void insertTest(String name) {
		AuthorVo vo0 = new AuthorVo();
		vo0.setName(name);
		new AuthorDao().insert(vo0);
	}
	
	private static void deleteTest_1() {
		AuthorDao dao = new AuthorDao();
		dao.delete(13L);
		dao.delete(14L);
		dao.delete(15L);
		dao.delete(16L);
		dao.delete(17L);
		dao.delete(18L);
	}
	
	private static void deleteTest_2() {
		AuthorDao dao = new AuthorDao();
		dao.delete("스테파니메이어");
		dao.delete("조정래");
		dao.delete("김동인");
		dao.delete("김난도");
		dao.delete("천상병");
		dao.delete("원수연");
	}
	
	private static void updateTest() {
		AuthorVo vo0 = new AuthorVo();
		vo0.setName("스테파니메이어");
		vo0.setNo(1L);
		AuthorVo vo1 = new AuthorVo();
		vo1.setName("조정래");
		vo1.setNo(2L);
		AuthorVo vo2 = new AuthorVo();
		vo2.setName("김동인");
		vo2.setNo(3L);
		AuthorVo vo3 = new AuthorVo();
		vo3.setName("김난도");
		vo3.setNo(4L);
		AuthorVo vo4 = new AuthorVo();
		vo4.setName("천상병");
		vo4.setNo(5L);
		AuthorVo vo5 = new AuthorVo();
		vo5.setName("원수연");
		vo5.setNo(6L);
		
		AuthorDao dao = new AuthorDao();
		dao.update(vo0);
		dao.update(vo1);
		dao.update(vo2);
		dao.update(vo3);
		dao.update(vo4);
		dao.update(vo5);
	}
	
	private static void selectTest() {
		AuthorDao dao = new AuthorDao();
		List<AuthorVo> list = dao.select();
		
		for(AuthorVo vos : list) {
			System.out.println(vos);
		}
	}

}
