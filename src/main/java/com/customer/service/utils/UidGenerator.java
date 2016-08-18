package com.customer.service.utils;

import java.security.SecureRandom;
import java.util.Random;

public class UidGenerator {
		
	
	  private static final Random RANDOM = new SecureRandom();
	  /** Length of password. @see #generateRandomPassword() */
	  public static final int UID_LENGTH = 6;
	  public static final int ID_LENGTH = 2;
	  /**
	   * Generate a random String suitable for use as a temporary password.
	   *
	   * @return String suitable for use as a temporary password
	   * @since 2.4
	   */
	  public static String generateRandomUid()
	  {
	      // Pick from some letters that won't be easily mistaken for each
	      // other. So, for example, omit o O and 0, 1 l and L.
	      String letters = "1234567890";

	      String pw = "";
	      for (int i=0; i<UID_LENGTH; i++)
	      {
	          int index = (int)(RANDOM.nextDouble()*letters.length());
	          pw += letters.substring(index, index+1);
	      }
	      return pw;
	  }
	  
	  
	  public static String generateRandomid()
	  {
	      // Pick from some letters that won't be easily mistaken for each
	      // other. So, for example, omit o O and 0, 1 l and L.
	      String letters = "abcdefghijklmnopqrs23456789@#$%^&*!";

	      String pw = "";
	      for (int i=0; i<ID_LENGTH; i++)
	      {
	          int index = (int)(RANDOM.nextDouble()*letters.length());
	          pw += letters.substring(index, index+1);
	      }
	      return pw;
	  }
}
