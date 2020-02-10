package com.douzone.bookmall.main;

import java.util.List;
import java.util.Scanner;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookMallApp {

	public static void main(String[] args) {
		displayBookInfo();
		
		System.out.println("대여할 책의 번호를 선택하세요!");
		Scanner scanner = new Scanner(System.in);
		Long no = scanner.nextLong();
		scanner.close();
		
		rent(no);
		
		displayBookInfo();
		
	}

	public static void displayBookInfo() {
		System.out.println("*************** 도서 정보 출력 **********************");

		List<BookVo> list = new BookDao().select();
		for(BookVo vo : list) {
			System.out.println("["+vo.getNo()+"] 책 제목: "+vo.getTitle()+
							   "/ 작가: "+vo.getAuthorName()+
							   "/ 대여 유무: "+vo.getState());
		}
		
	}
	
	public static void rent(Long no) {
		new BookDao().stateUpdate(no, "대여중");
	}
}