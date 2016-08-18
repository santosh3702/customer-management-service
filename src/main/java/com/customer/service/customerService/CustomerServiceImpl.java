package com.customer.service.customerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.customer.service.password.utils.PasswordGenerator;
import com.customer.service.types.AddCustomerResponce;
import com.customer.service.types.Customer;
import com.customer.service.utils.QueryConstants;
import com.customer.service.utils.UidGenerator;
import com.customer.service.validationException.ValidationException;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AddCustomerResponce addCustomer(Customer customer) throws ValidationException {
		AddCustomerResponce addCustomerResponce =  new AddCustomerResponce();
		String status = null;
		String customerUid = UidGenerator.generateRandomUid();
		String customerid = "CID01"+customerUid;
		String customerPassword = PasswordGenerator.generateRandomPassword();
		String username = customer.getfName()+UidGenerator.generateRandomid();
		status = addCustomerDboperation(customer,customerid,customerPassword,username);
		addCustomerResponce.setStatus(status);
		addCustomerResponce.setLoginid(username);
		addCustomerResponce.setPassword(customerPassword);
		addCustomerResponce.setCustomerId(customerid);
		return addCustomerResponce;
	}

	private String addCustomerDboperation(Customer customer,String customerid,String customerPassword,String username) {
		String response = null;
		List<String> args = new ArrayList<String>();
		args.add(customer.getGender().toString());
		args.add(customer.getEmail());
		args.add(customer.getContactNo());
		args.add(customer.getfName());
		args.add(customer.getsName());
		args.add(customerid);
		args.add(customerPassword);
		args.add(username);
		args.add(customer.getAddress().getAddressLine1());
		args.add(customer.getAddress().getAddressLine2());
		args.add(customer.getAddress().getCity());
		args.add(customer.getAddress().getState());
		args.add(customer.getAddress().getCountry());
		args.add(customer.getAddress().getZipcode());
		int result = jdbcTemplate.update(QueryConstants.CUSTOMER_INSERT, args.toArray());
		if (result > 0) {
			response = "Success";
		} else {
			response = "Failed";
		}
		return response;
	}

}
