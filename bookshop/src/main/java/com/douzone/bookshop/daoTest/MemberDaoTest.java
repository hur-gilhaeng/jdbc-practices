package com.douzone.bookshop.daoTest;

import java.util.List;

import com.douzone.bookshop.dao.MemberDao;
import com.douzone.bookshop.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		//insertTest();
		displayMember();
	}
	public static void insertTest(){
		insertMemberTest("김철수","010-0000-0000","kim@email.com","kim0000!");
		insertMemberTest("이영희","010-0000-0001","lee@email.com","lee0000!");
	}
	
	public static void displayMember() {
		List<MemberVo> list = new MemberDao().allSelect();
		
		for(MemberVo vos : list) {
			System.out.println("고객 번호 :"+vos.getMemberNo()+
							   ", 이름 : "+vos.getName()+
							   ", 전화번호 : "+vos.getPhone()+
							   ", e-mail : "+vos.getEmail()+
							   ", 비밀번호 : "+vos.getPassword());
		}
	}
	
	public static void insertMemberTest(
			String name,String phone,String email,String password) {
		
		MemberVo vo = new MemberVo();
		
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPassword(password);
		
		new MemberDao().insert(vo);
	}

}
