/**
 * 
 */
package com.customer.service.utils;

/**
 * @author rkonki001c
 */
public enum ErrorCode implements java.io.Serializable {

    /**
     * Error Codes
     */

    EC_1001("CUSTOMERMANAGEMENT-1001"),
    EC_1002("CUSTOMERMANAGEMENT-1002");

    // String that represents a property
    private String property = null;

    /**
     * Enum constructor
     */
    ErrorCode(String property) {
        this.property = property;
    }

    /**
     * Return the enumeration from the String
     * 
     * @link ErrorCode
     */
    public static ErrorCode fromValue(String value) {
        return valueOf(value);
    }

    /**
     * Return the value of enumeration
     * 
     * @return enumerationValue {@link String}
     */
    public String getValue() {
        return property;
    }

}
