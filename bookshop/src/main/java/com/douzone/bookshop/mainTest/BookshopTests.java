package com.douzone.bookshop.mainTest;

import com.douzone.bookshop.daoTest.BookDaoTest;
import com.douzone.bookshop.daoTest.CartDaoTest;
import com.douzone.bookshop.daoTest.CategoryDaoTest;
import com.douzone.bookshop.daoTest.MemberDaoTest;
import com.douzone.bookshop.daoTest.OrderDaoTest;

public class BookshopTests {

	public static void main(String[] args) {
		// 전체 테스트
		insertTest();
		allView();
	}

	public static void insertTest() {

		MemberDaoTest.insertTest();
		/**
		 * insertMemberTest("김철수","010-0000-0000","kim@email.com","kim0000!");
		 * insertMemberTest("이영희","010-0000-0001","lee@email.com","lee0000!");
		 **/
		
		CategoryDaoTest.insertTest();
		/**
		 * insertCategoryTest("소설");
		 * insertCategoryTest("컴퓨터/IT");
		 * insertCategoryTest("교양");
		 **/
		
		BookDaoTest.insertTest();
		/**
		 * insertBookTest("위저드 베이커리",12000,1L);
		 * insertBookTest("이것이 자바다",32000,2L);
		 * insertBookTest("도시는 무엇으로 사는가",20000,3L);
		 **/
		
		CartDaoTest.insertTest();
		/**
		 * insertCartTest(1L, 1L, 3);
		 * insertCartTest(1L, 2L, 1);
		 **/
		
		OrderDaoTest.insertTest();
		/**
		 * insertOrderTest("20200101-00001",1L,68000,"경기도 포천시 이동면");
		 * insertOrderBookTest("20200101-00001",2L,2);
		 * insertOrderBookTest("20200101-00001",3L,4);
		 **/

	}

	public static void allView() {
		System.out.println("========== 고객 정보 ==========");
		MemberDaoTest.displayMember();
		System.out.println();

		System.out.println("========== 카테고리 정보 ==========");
		CategoryDaoTest.displayCategory();
		System.out.println();

		System.out.println("========== 도서 정보 ==========");
		BookDaoTest.displayBook();
		System.out.println();

		System.out.println("========== 고객별 카트리스트  ==========");
		CartDaoTest.displayCart();
		System.out.println();

		System.out.println("========== 주문 정보 ==========");
		OrderDaoTest.displayOrder();
	}

}
