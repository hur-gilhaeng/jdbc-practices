package com.douzone.bookshop.vo;

public class OrderVo {
	private String orderNo;
	private Long memberNo;
	private int orderTotal;
	private String orderAddr;

	private String name;
	private String email;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "OrderVo [orderNo=" + orderNo + ", memberNo=" + memberNo + ", orderTotal=" + orderTotal + ", orderAddr="
				+ orderAddr + ", name=" + name + ", email=" + email + "]";
	}

}