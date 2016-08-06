package com.andieguo.propertiesutil;


/**
 * Thrown on a property parse exception. Intended to report missing or invalid
 * properties.
 *
 * @see com.thetransactioncompany.util.PropertyRetriever
 *
 * @author Vladimir Dzhuvinov
 */
public class PropertyParseException
	extends Exception {
	
	
	/**
	 * The key of the property that caused the exception, {@code null} if
	 * unknown or not applicable.
	 */
	private final String propertyKey;
	
	
	/**
	 * The value of the property that caused the exception, {@code null} if
	 * unknown or not applicable.
	 */
	private final String propertyValue;
	
	
	/**
	 * Creates a new property parse exception with the specified message.
	 *
	 * @param message The exception message.
	 */
	public PropertyParseException(final String message) {
	
		super(message);
		propertyKey = null;
		propertyValue = null;
	}
	
	
	/**
	 * Creates a new property parse exception with the specified message and
	 * property key.
	 *
	 * @param message     The exception message.
	 * @param propertyKey The key of the property that caused the exception,
	 *                    {@code null} if unknown or not applicable.
	 */
	public PropertyParseException(final String message, final String propertyKey) {
	
		super(message);
		this.propertyKey = propertyKey;
		propertyValue = null;
	}
	
	
	/**
	 * Creates a new property parse exception with the specified message,
	 * property key and property value.
	 *
	 * @param message       The exception message.
	 * @param propertyKey   The key of the property that caused the
	 *                      exception, {@code null} if unknown or not
	 *                      applicable.
	 * @param propertyValue The value of the property that caused the
	 *                      exception, {@code null} if unknown or not
	 *                      applicable.
	 */
	public PropertyParseException(final String message, final String propertyKey, final String propertyValue) {
	
		super(message);
		this.propertyKey = propertyKey;
		this.propertyValue = propertyValue;
	}
	
	
	/**
	 * Returns the key of the property that caused the exception, 
	 * {@code null} if unknown or not applicable.
	 * 
	 * @return The key of the offending property.
	 */
	public String getPropertyKey() {
	
		return propertyKey;
	}
	
	
	/**
	 * Returns the value of the property that caused the exception,
	 * {@code null} if unknown or not applicable.
	 *
	 * @return The value of the offending property.
	 */
	public String getPropertyValue() {
	
		return propertyValue;
	}
}
