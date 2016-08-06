package com.andieguo.propertiesutil;


import java.net.URL;
import java.util.Properties;

import junit.framework.TestCase;


/**
 * Tests the property retriever class.
 *
 * @author Vladimir Dzhuvinov
 */
public class PropertyRetrieverTest extends TestCase {


	public void testGetBoolean()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.enable", "true");
		props.setProperty("app.reload", "false");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertTrue(pr.getBoolean("app.enable"));
		assertFalse(pr.getBoolean("app.reload"));

		try {
			pr.getBoolean("app.disable");
			fail();
		} catch (PropertyParseException e) {
			assertEquals("app.disable", e.getPropertyKey());
		}
	}


	public void testGetOptBoolean()
		throws Exception {

		PropertyRetriever pr = new PropertyRetriever(new Properties());

		assertTrue(pr.getOptBoolean("app.enable", true));
	}


	public void testGetOptBooleanEmpty()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.enable", " ");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertTrue(pr.getOptBoolean("app.enable", true));
	}


	public void testGetInt()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.threadCount", "10");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals(10, pr.getInt("app.threadCount"));

		try {
			pr.getInt("app.someCount");
			fail();
		} catch (PropertyParseException e) {
			assertEquals("app.someCount", e.getPropertyKey());
		}
	}


	public void testgetOptInt()
		throws Exception {

		PropertyRetriever pr = new PropertyRetriever(new Properties());

		assertEquals(10, pr.getOptInt("app.threadCount", 10));
	}


	public void testgetOptIntEmpty()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.threadCount", " ");

		PropertyRetriever pr = new PropertyRetriever(new Properties());

		assertEquals(10, pr.getOptInt("app.threadCount", 10));
	}


	public void testGetLong()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.timeout", "1000");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals(1000l, pr.getLong("app.timeout"));

		try {
			pr.getInt("app.someTimeout");
			fail();
		} catch (PropertyParseException e) {
			assertEquals("app.someTimeout", e.getPropertyKey());
		}
	}


	public void testGetOptLong()
		throws Exception {

		PropertyRetriever pr = new PropertyRetriever(new Properties());

		assertEquals(1000l, pr.getOptLong("app.timeout", 1000l));
	}


	public void testGetOptLongEmpty()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.timeout", " ");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals(1000l, pr.getOptLong("app.timeout", 1000l));
	}


	public void testGetFloat()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.pi", "3.14");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals(new Float("3.14"), pr.getFloat("app.pi"));

		try {
			pr.getInt("app.someFloat");
			fail();
		} catch (PropertyParseException e) {
			assertEquals("app.someFloat", e.getPropertyKey());
		}
	}


	public void testGetOptFloat()
		throws Exception {

		PropertyRetriever pr = new PropertyRetriever(new Properties());

		assertEquals(new Float("3.14"), pr.getOptFloat("app.pi", new Float(3.14)));
	}


	public void testGetString()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.name", "CoolApp");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals("CoolApp", pr.getString("app.name"));

		try {
			pr.getInt("app.someString");
			fail();
		} catch (PropertyParseException e) {
			assertEquals("app.someString", e.getPropertyKey());
		}
	}


	public void testGetOptString()
		throws Exception {

		PropertyRetriever pr = new PropertyRetriever(new Properties());

		assertEquals("CoolApp", pr.getOptString("app.name", "CoolApp"));
	}


	public void testGetOptStringEmpty()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.name", " ");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals("CoolApp", pr.getOptString("app.name", "CoolApp"));
	}


	public void testGetEnumString()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.color", "red");

		PropertyRetriever pr = new PropertyRetriever(props);

		String[] colors = {"red", "green", "blue"};

		assertEquals("red", pr.getEnumString("app.color", colors));
	}


	public void testGetOptEnumString()
		throws Exception {

		PropertyRetriever pr = new PropertyRetriever(new Properties());

		String[] colors = {"red", "green", "blue"};

		assertEquals("red", pr.getOptEnumString("app.color", colors, "red"));
	}


	public void testGetOptEnumStringEmpty()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.color", " ");

		PropertyRetriever pr = new PropertyRetriever(props);

		String[] colors = {"red", "green", "blue"};

		assertEquals("red", pr.getOptEnumString("app.color", colors, "red"));
	}


	public void testGetEnum()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.timeUnit", "SECONDS");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals(java.util.concurrent.TimeUnit.SECONDS, pr.getEnum("app.timeUnit", java.util.concurrent.TimeUnit.class));
	}


	public void testGetOptEnum()
		throws Exception {

		PropertyRetriever pr = new PropertyRetriever(new Properties());

		assertEquals(java.util.concurrent.TimeUnit.SECONDS, 
			     pr.getOptEnum("app.timeUnit", 
			     	           java.util.concurrent.TimeUnit.class, 
			     	           java.util.concurrent.TimeUnit.SECONDS));
	}


	public void testGetOptEnumEmpty()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.timeUnit", " ");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals(java.util.concurrent.TimeUnit.SECONDS, 
			     pr.getOptEnum("app.timeUnit", 
			     	           java.util.concurrent.TimeUnit.class, 
			     	           java.util.concurrent.TimeUnit.SECONDS));
	}


	public void testGetURL()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.url", "http://app.com");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals(new URL("http://app.com"), pr.getURL("app.url"));
	}


	public void testGetOptURL()
		throws Exception {

		PropertyRetriever pr = new PropertyRetriever(new Properties());

		assertEquals(new URL("http://app.com"), pr.getOptURL("app.url", new URL("http://app.com")));
	}


	public void testGetOptURLEmpty()
		throws Exception {

		Properties props = new Properties();
		props.setProperty("app.url", " ");

		PropertyRetriever pr = new PropertyRetriever(props);

		assertEquals(new URL("http://app.com"), pr.getOptURL("app.url", new URL("http://app.com")));
	}
}