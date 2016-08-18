package com.customer.service.customerService;

import com.customer.service.types.AddCustomerResponce;
import com.customer.service.types.Customer;
import com.customer.service.validationException.ValidationException;

public interface CustomerService {

	public AddCustomerResponce addCustomer(Customer customer) throws ValidationException;
}
