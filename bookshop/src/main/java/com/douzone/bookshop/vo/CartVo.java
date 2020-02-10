package com.douzone.bookshop.vo;

public class CartVo {
	private Long meberNo;
	private Long bookNo;
	private int bookAmount;
	private int price;
	private String bookTitle;

	public Long getMeberNo() {
		return meberNo;
	}

	public void setMeberNo(Long meberNo) {
		this.meberNo = meberNo;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public int getBookAmount() {
		return bookAmount;
	}

	public void setBookAmount(int bookAmount) {
		this.bookAmount = bookAmount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "CartVo [meberNo=" + meberNo + ", bookNo=" + bookNo + ", bookAmount=" + bookAmount + ", price=" + price
				+ ", bookTitle=" + bookTitle + "]";
	}

}
