package com.andieguo.propertiesutil;


import junit.framework.TestCase;


/**
 * Tests the property exception class.
 */
public class PropertyParseExceptionTest extends TestCase {


	public void testMinimalConstructor() {

		PropertyParseException e = new PropertyParseException("message");
		assertEquals("message", e.getMessage());
		assertNull(e.getPropertyKey());
		assertNull(e.getPropertyValue());
		assertNull(e.getCause());
	}


	public void testPropertyKeyConstructor() {

		PropertyParseException e = new PropertyParseException("message", "key");
		assertEquals("message", e.getMessage());
		assertEquals("key", e.getPropertyKey());
		assertNull(e.getPropertyValue());
		assertNull(e.getCause());
	}


	public void testFullConstructor() {

		PropertyParseException e = new PropertyParseException("message", "key", "value");
		assertEquals("message", e.getMessage());
		assertEquals("key", e.getPropertyKey());
		assertEquals("value", e.getPropertyValue());
		assertNull(e.getCause());
	}



	public void testFullConstructorWithNulls() {

		PropertyParseException e = new PropertyParseException(null, null, null);
		assertNull(e.getMessage());
		assertNull(e.getPropertyKey());
		assertNull(e.getPropertyValue());
		assertNull(e.getCause());
	}
}
