package com.douzone.bookshop.vo;

public class BookVo {
	
	private Long bookNo;
	private String bookTitle;
	private int bookPrice;
	private Long categoryNo;
	private String categoryName;

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "BookVo [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + ", categoryNo="
				+ categoryNo + ", categoryName=" + categoryName + "]";
	}

}
