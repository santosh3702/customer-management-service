package com.customer.service.validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.customer.service.extractor.CustomerExtractor;
import com.customer.service.types.Customer;
import com.customer.service.utils.ErrorCode;
import com.customer.service.utils.QueryConstants;
import com.customer.service.validationException.ValidationException;

@Component
@Aspect
public class CustomerServiceValidation {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Pointcut("execution(* com.customer.service.customerService.CustomerServiceImpl.addCustomer(..)) && args(customer))")
	private void addCustomer(Customer customer) {
	}
	
	
	@Before("addCustomer(customer)")
	public void addCustomerValidation(Customer customer) throws ValidationException {
		if (customer == null) {
			String code = ErrorCode.EC_1001.getValue();
			String message = messageSource.getMessage(code, null, "Default", Locale.getDefault());
			throw new ValidationException(message, HttpStatus.BAD_REQUEST);
		}
		if (customer.getAddress() == null || customer.getContactNo() == null || customer.getEmail() == null
				|| customer.getfName() == null || customer.getsName() == null || customer.getGender() == null) {
			String code = ErrorCode.EC_1001.getValue();
			String message = messageSource.getMessage(code, null, "Default", Locale.getDefault());
			throw new ValidationException(message, HttpStatus.BAD_REQUEST);
		} else {
			if(customerIsExists(customer)){
				String code = ErrorCode.EC_1002.getValue();
				String message = messageSource.getMessage(code, null, "Default", Locale.getDefault());
				throw new ValidationException(message, HttpStatus.BAD_REQUEST);
			}	
		}
	}

	private boolean customerIsExists(Customer customer) {
		boolean response = false;
		List<String> args = new ArrayList<String>();
		args.add(customer.getEmail());
		args.add(customer.getContactNo());
		try {
			List<Customer> customerList = jdbcTemplate.query(QueryConstants.CUSTOMER_EXIST, args.toArray(),
					new CustomerExtractor());
			if (!StringUtils.isEmpty(customerList) && customerList.size() > 0) {
				response = true;
			} else {
				response = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
}
