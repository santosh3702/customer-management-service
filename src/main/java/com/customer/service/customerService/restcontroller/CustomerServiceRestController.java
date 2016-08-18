package com.customer.service.customerService.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.customer.service.customerService.CustomerService;
import com.customer.service.types.AddCustomerResponce;
import com.customer.service.types.Customer;
import com.customer.service.validationException.ValidationException;

@RestController
@RequestMapping(value = "/customerService/")
public class CustomerServiceRestController {
	
	@Autowired
	private CustomerService customerService;
	@Value("${greeting\\u0020}")
	private String message ;
	
	@RequestMapping("/")
	public String test() {
		return "Customer-Service-Contorller" + message;
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public @ResponseBody AddCustomerResponce addCustomer(@RequestBody Customer customer) throws ValidationException{
		return customerService.addCustomer(customer);
	}
	
	

}
