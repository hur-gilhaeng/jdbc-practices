package com.douzone.bookshop.vo;

public class OrderBookVo {
	private String orderNo;
	private Long bookNo;
	private int bookAmount;
	private String bookTitle;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "OrderBookVo [orderNo=" + orderNo + ", bookNo=" + bookNo + ", bookAmount=" + bookAmount + ", bookTitle="
				+ bookTitle + "]";
	}

}
