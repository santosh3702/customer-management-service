package com.customer.service.extractor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.customer.service.types.Customer;

public class CustomerExtractor implements ResultSetExtractor<List<Customer>>{

	public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Customer> customerList = new ArrayList<Customer>();
		Customer customer = null;
		while (rs.next()) {
			customer = new Customer();
			customer.setContactNo(rs.getString("contactNo"));
			customer.setEmail(rs.getString("email"));
			customer.setfName(rs.getString("fName"));
			customer.setsName(rs.getString("sName"));
			customerList.add(customer);
		}
		return customerList;
	}
}
