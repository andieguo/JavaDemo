package com.andieguo.propertiesutil;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


/**
 * Provides typed retrieval of {@link java.util.Properties} as {@code boolean}, 
 * {@code int}, {@code long}, {@code float}, {@code double}, 
 * {@link java.lang.String}, {@link java.net.URL} or {@code enum} values.
 *
 * @author Vladimir Dzhuvinov
 */
public class PropertyRetriever {

	
	/** 
	 * The property hashtable to parse. 
	 */
	private Properties props;


	/**
	 * Creates a new retriever for the specified properties.
	 *
	 * @param props The properties hasthtable.
	 */
	public PropertyRetriever(final Properties props) {
	
		this.props = props;
	}
	
	
	/**
	 * Retrieves a boolean value.
	 *
	 * @param key The property name.
	 *
	 * @return The property as a boolean value.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public boolean getBoolean(final String key)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null)
			throw new PropertyParseException("Missing property", key);
		
		if (value.equalsIgnoreCase("true"))
			return true;
		
		else if (value.equalsIgnoreCase("false"))
			return false;
		
		else
			throw new PropertyParseException("Invalid boolean property", key, value);
	}
	
	
	/**
	 * Retrieves an optional boolean value.
	 *
	 * @param key The property name.
	 * @param def The default value if the property value is undefined or
	 *            empty.
	 *
	 * @return The property as a boolean.
	 *
	 * @throws PropertyParseException On an invalid property.
	 */
	public boolean getOptBoolean(final String key, final boolean def)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null || value.trim().isEmpty())
			return def;
		
		if (value.equalsIgnoreCase("true"))
			return true;
		
		if (value.equalsIgnoreCase("false"))
			return false;
		
		throw new PropertyParseException("Invalid boolean property", key, value);
	}
	
	
	/**
	 * Retrieves an integer value.
	 *
	 * @param key The property name.
	 *
	 * @return The property as an integer.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public int getInt(final String key)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null)
			throw new PropertyParseException("Missing property", key);
		
		try {
			return Integer.parseInt(value);
		
		} catch (NumberFormatException e) {

			throw new PropertyParseException("Invalid int property", key, value);
		}
	}
	
	
	/**
	 * Retrieves an optional integer value.
	 *
	 * @param key The property name.
	 * @param def The default value if the property value is undefined or
	 *            empty.
	 *
	 * @return The property as an integer.
	 *
	 * @throws PropertyParseException On an invalid property.
	 */
	public int getOptInt(final String key, final int def)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null || value.trim().isEmpty())
			return def;
		
		try {
			return Integer.parseInt(value);
		
		} catch (NumberFormatException e) {

			throw new PropertyParseException("Invalid int property", key);
		}
	}
	
	
	/**
	 * Retrieves a long value.
	 *
	 * @param key The property name.
	 *
	 * @return The property as a long.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public long getLong(final String key)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null)
			throw new PropertyParseException("Missing property", key);
		
		try {
			return Long.parseLong(value);
		
		} catch (NumberFormatException e) {

			throw new PropertyParseException("Invalid long property", key, value);
		}
	}
	
	
	/**
	 * Retrieves an optional long value.
	 *
	 * @param key The property name.
	 * @param def The default value if the property value is undefined or
	 *            empty.
	 *
	 * @return The property as a long.
	 *
	 * @throws PropertyParseException On an invalid property.
	 */
	public long getOptLong(final String key, final long def)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null || value.trim().isEmpty())
			return def;
		
		try {
			return Long.parseLong(value);
		
		} catch (NumberFormatException e) {

			throw new PropertyParseException("Invalid long property", key, value);
		}
	}
	
	
	/**
	 * Retrieves a float value.
	 *
	 * @param key The property name.
	 *
	 * @return The property as a float.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public float getFloat(final String key)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null)
			throw new PropertyParseException("Missing property", key);
		
		try {
			return Float.parseFloat(value);
		
		} catch (NumberFormatException e) {

			throw new PropertyParseException("Invalid float property", key, value);
		}
	}
	
	
	/**
	 * Retrieves an optional float value.
	 *
	 * @param key The property name.
	 * @param def The default value if the property value is undefined or
	 *            empty.
	 *
	 * @return The property as a float.
	 *
	 * @throws PropertyParseException On an invalid property.
	 */
	public float getOptFloat(final String key, final float def)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null || value.trim().isEmpty())
			return def;
		
		try {
			return Float.parseFloat(value);
		
		} catch (NumberFormatException e) {

			throw new PropertyParseException("Invalid float property", key, value);
		}
	}
	
	
	/**
	 * Retrieves a double value.
	 *
	 * @param key The property name.
	 *
	 * @return The property as a double.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public double getDouble(final String key)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null)
			throw new PropertyParseException("Missing property", key);
		
		try {
			return Double.parseDouble(value);
		
		} catch (NumberFormatException e) {

			throw new PropertyParseException("Invalid double property", key, value);
		}
	}
	
	
	/**
	 * Retrieves an optional double value.
	 *
	 * @param key The property name.
	 * @param def The default value if the property value is undefined or
	 *            empty.
	 *
	 * @return The property as a double.
	 *
	 * @throws PropertyParseException On an invalid property.
	 */
	public double getOptDouble(final String key, final double def)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null || value.trim().isEmpty())
			return def;
		
		try {
			return Double.parseDouble(value);
		
		} catch (NumberFormatException e) {

			throw new PropertyParseException("Invalid double property", key, value);
		}
	}
	
	
	/**
	 * Retrieves a string value.
	 *
	 * @param key The property name.
	 *
	 * @return The property as a string.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public String getString(final String key)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null)
			throw new PropertyParseException("Missing property", key);
		
		return value;
	}
	
	
	/**
	 * Retrieves an optional string value.
	 *
	 * @param key The property name.
	 * @param def The default value if the property value is undefined or
	 *            empty.
	 *
	 * @return The property as a string.
	 *
	 * @throws PropertyParseException On an invalid property.
	 */
	public String getOptString(final String key, final String def)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null || value.trim().isEmpty())
			return def;
		
		return value;
	}
	
	
	/**
	 * Retrieves an enumerated string value. String case is ignored during
	 * comparison.
	 *
	 * @param key   The property name.
	 * @param enums A string array defining the acceptable values.
	 *
	 * @return The property as a string.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public String getEnumString(final String key, final String[] enums)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null)
			throw new PropertyParseException("Missing property", key);
		
		for (String en: enums) {
			
			if (en.equalsIgnoreCase(value))
				return value;
		}
			
		throw new PropertyParseException("Invalid enum string property", key, value);
	}
	
	
	/**
	 * Retrieves an enumerated string value. String case is ignored during
	 * comparison.
	 *
	 * @param key   The property name.
	 * @param enums A string array defining the acceptable values.
	 * @param def   The default value if the property value is undefined or
	 *              empty.
	 *
	 * @return The property as a string.
	 *
	 * @throws PropertyParseException On an invalid property.
	 */
	public String getOptEnumString(final String key, final String[] enums, final String def)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null || value.trim().isEmpty())
			return def;
		
		for (String en: enums) {
			
			if (en.equalsIgnoreCase(value))
				return value;
		}
			
		throw new PropertyParseException("Invalid enum string property", key, value);
	}
	
	
	/**
	 * Retrieves an enumerated constant. String case is ignored during
	 * comparison.
	 *
	 * @param key       The property name.
	 * @param enumClass The enumeration class specifying the acceptable
	 *                  values.
	 *
	 * @return The matching enumerated constant.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public <T extends Enum<T>> T getEnum(final String key, final Class<T> enumClass)
		throws PropertyParseException {
		
		String value = props.getProperty(key);
		
		if (value == null)
			throw new PropertyParseException("Missing property", key);
			
		for (T en: enumClass.getEnumConstants()) {
		
			if (en.toString().equalsIgnoreCase(value))
				return en;
		}
		
		// No match? -> raise exception
		throw new PropertyParseException("Invalid enum property", key, value);
	}
	
	
	/**
	 * Retrieves an optional enumerated constant. String case is ignored
	 * during comparison.
	 *
	 * @param key       The property name.
	 * @param enumClass The enumeration class specifying the acceptable
	 *                  values.
	 * @param def       The default value if the property value is 
	 *                  undefined or empty.
	 *
	 * @return The matching enumerated constant.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public <T extends Enum<T>> T getOptEnum(final String key, final Class<T> enumClass, final T def)
		throws PropertyParseException {
		
		String value = props.getProperty(key);
		
		if (value == null || value.trim().isEmpty())
			return def;
			
		for (T en: enumClass.getEnumConstants()) {
		
			if (en.toString().equalsIgnoreCase(value))
				return en;
		}
		
		// No match? -> raise exception
		throw new PropertyParseException("Invalid enum property", key, value);
	}


	/**
	 * Retrieves a URL value.
	 *
	 * @param key The property name.
	 *
	 * @return The property as a URL.
	 *
	 * @throws PropertyParseException On a missing or invalid property.
	 */
	public URL getURL(final String key)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null)
			throw new PropertyParseException("Missing property", key);
		
		try {
			return new URL(value);

		} catch (MalformedURLException e) {

			throw new PropertyParseException("Invalid URL property: " + e.getMessage(), key, value);
		}
	}
	
	
	/**
	 * Retrieves an optional URL value.
	 *
	 * @param key The property name.
	 * @param def The default value if the property value is undefined or
	 *            empty.
	 *
	 * @return The property as a URL.
	 *
	 * @throws PropertyParseException On an invalid property.
	 */
	public URL getOptURL(final String key, final URL def)
		throws PropertyParseException {
	
		String value = props.getProperty(key);
		
		if (value == null || value.trim().isEmpty())
			return def;
		
		try {
			return new URL(value);

		} catch (MalformedURLException e) {

			throw new PropertyParseException("Invalid URL property: " + e.getMessage(), key, value);
		}
	}
}
