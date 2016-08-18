package com.customer.service.types;

import java.util.List;




public class OrdersDetails {

	 public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	protected String cId;
	 
	 protected List<Items> itemsList;
	 
	 protected String oId;
	 
	 protected Payment payment;
	 
}
