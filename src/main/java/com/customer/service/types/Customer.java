package com.customer.service.types;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class Customer {

	 	protected Address address;
	    
	 	public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getContactNo() {
			return contactNo;
		}

		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public String getfName() {
			return fName;
		}

		public void setfName(String fName) {
			this.fName = fName;
		}

		public String getsName() {
			return sName;
		}

		public void setsName(String sName) {
			this.sName = sName;
		}

		protected String contactNo;
	    
	    @NotNull
	    @Email
	    protected String email;
	    
	    protected Gender gender;
	    
	    @NotNull
	    protected String fName;
	    
	    protected String sName;
}
