package com.douzone.bookshop.daoTest;

import java.util.List;

import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		//insertTest();
		displayCategory();
	}
	
	public static void insertTest(){
		insertCategoryTest("소설");
		insertCategoryTest("컴퓨터/IT");
		insertCategoryTest("교양");
	}
	
	public static void displayCategory() {
		List<CategoryVo> list = new CategoryDao().allSelect();
		
		for(CategoryVo vos : list) {
			System.out.println("카테고리 "+vos.getCategoryNo()+
							   "번 : "+vos.getCategoryName());
		}
	}
	
	public static void insertCategoryTest(String categoryName) {
		CategoryVo vo = new CategoryVo();
		
		vo.setCategoryName(categoryName);
		
		new CategoryDao().insert(vo);
	}
}
