package com.customer.service.utils;

public class QueryConstants {

	public static final String CUSTOMER_EXIST = "select * from customermanagement where contactNo = ? AND email = ? ";
	
	public static final String CUSTOMER_INSERT = "insert into  customermanagement values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
}
