package com.andieguo.lang3;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.MutableTriple;

import com.andieguo.generics.Animal;

import junit.framework.Assert;
import junit.framework.TestCase;

public class UtilsTester extends TestCase {

	public void testArrayUtils(){
		 String[][] color = new String[][]{{"RED", "#FF0000"},{"GREEN", "#00FF00"},{"BLUE", "#0000FF"}};
		 Map colorMap = ArrayUtils.toMap(color);
		 System.out.println(colorMap);
	}
	
	public void testToString(){
		String[] numbers = new String[]{"1","2","3",null};
		String[][] color = new String[][]{{"RED", "#FF0000"},{"GREEN", "#00FF00"},{"BLUE", "#0000FF"}};
		System.out.println(new ToStringBuilder(numbers, ToStringStyle.DEFAULT_STYLE).append(numbers).toString());
		System.out.println(ArrayUtils.toString(numbers));
		System.out.println(ArrayUtils.toString(color));
	}
	
	public void testEqual(){
		String[] numbers = new String[]{"1","2","3"};
		String[] numbersNew = new String[]{"2","1","3"};
		Assert.assertEquals(false, ArrayUtils.isEquals(numbers, numbersNew));
	}
	
	public void testToArray(){
		Integer[] result = ArrayUtils.toArray(1,2,3,4);
		System.out.println(ArrayUtils.toString(result));
	}
	
	public void testBooleanUtils(){
		//对于isFalse方法而言，只有值为false才返回true
		Assert.assertEquals(true, BooleanUtils.isFalse(false));
		Assert.assertEquals(false, BooleanUtils.isFalse(true));
		Assert.assertEquals(false, BooleanUtils.isFalse(null));
		Assert.assertEquals(1, BooleanUtils.toInteger(Boolean.TRUE, 1, 0, 2));
		Assert.assertEquals(0, BooleanUtils.toInteger(Boolean.FALSE, 1, 0, 2));
		Assert.assertEquals(2, BooleanUtils.toInteger(null, 1, 0, 2));
	}
	
	public void testToStringBuilder(){
		System.out.println(ToStringBuilder.reflectionToString(new Animal("cat"),ToStringStyle.DEFAULT_STYLE));
		System.out.println(ToStringBuilder.reflectionToString(new Animal("cat"),ToStringStyle.SHORT_PREFIX_STYLE));
	}
	
	/**
	 * commons lang3.3发布之后便有了这个类,用于产生一个范围内的随机数。
	 */
	public void testRandomUtils(){
		RandomUtils.nextInt(0,10);
		RandomUtils.nextDouble(0.0, 10.0);
		//产生5位长度的随机字符串，中文环境下是乱码
		RandomStringUtils.random(5);
		//使用指定的字符生成5位长度的随机字符串
		RandomStringUtils.random(5, new char[]{'a','b','c','d','e','f', '1', '2', '3'});
		//生成指定长度的字母和数字的随机组合字符串
		RandomStringUtils.randomAlphanumeric(5);
		//生成随机数字字符串
		RandomStringUtils.randomNumeric(5);
		//生成随机[a-z]字符串，包含大小写
		RandomStringUtils.randomAlphabetic(5);
		//生成从ASCII 32到126组成的随机字符串
		RandomStringUtils.randomAscii(4);
	}
	
	/**
	 * 它的所有操作都不会抛出异常，如果转换不成功返回0,0.0d,0.0f等形式。转换操作也可以指定默认值
	 */
	public void testNumberUtils(){
		//判断字符串是否为数字
		Assert.assertEquals(true, NumberUtils.isNumber("2.3212"));
		Assert.assertEquals(false, NumberUtils.isNumber("hello"));
		Assert.assertEquals(false, NumberUtils.isNumber(null));
		//将字符串转换为LONG
		Assert.assertEquals(1L, NumberUtils.toLong(null, 1L));
		Assert.assertEquals(1L, NumberUtils.toLong("hello", 1L));
		Assert.assertEquals(2L, NumberUtils.toLong("2", 1L));
		Assert.assertEquals(0L, NumberUtils.toLong(null));
		Assert.assertEquals(0L, NumberUtils.toLong("hello"));
		Assert.assertEquals(2L, NumberUtils.toLong("2"));
		//判断字符串是否全为数字
		Assert.assertEquals(false, NumberUtils.isDigits("0000000000.596"));
		Assert.assertEquals(true, NumberUtils.isDigits("0000000000596"));
	}
	
	/**
	 * 包含判断是否为空，trim及查找字符，分割，联合，子集，取得索引，切换大小写，替换，删除等功能
		及其判断是否为数字，是否为字符等
		 StringUtils.isNotBlank(null)      = false
		 StringUtils.isNotBlank("")        = false
		 StringUtils.isNotBlank(" ")       = false
		 StringUtils.isNotBlank("bob")     = true
		 StringUtils.isNotBlank("  bob  ") = true

	 */
	public void testStringUtils(){
		Assert.assertEquals(true, StringUtils.isNotBlank("hello"));
		Assert.assertEquals(false, StringUtils.isNotBlank(""));
		//判断字符串是否全为数字
		Assert.assertEquals(false, StringUtils.isNumeric("12.3"));
		Assert.assertEquals(true, StringUtils.isNumeric("123"));
	}
	
	public void testSystemUtils(){
		System.out.println(SystemUtils.getJavaHome().getAbsolutePath());
		System.out.println(SystemUtils.getUserHome().getAbsolutePath());
	}
	
	/**
	 * 增强的功能：深拷贝，方便的反序列化Deserialize ，序列化Serialize 等。
	 */
	public void testSerializationUtils(){
		SchoolBean schoolBean = new SchoolBean();
		schoolBean.setName("第二中学");
		schoolBean.setTeacher(new TeacherBean("校长"));
		SchoolBean newSchoolBean = SerializationUtils.clone(schoolBean);
		System.out.println(schoolBean);
		System.out.println(newSchoolBean);
	}
	
	public void testDateFormatUtils(){
		System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(new Date()));//2016-11-26T08:47:37
		System.out.println(DateFormatUtils.ISO_DATE_TIME_ZONE_FORMAT.format(new Date()));//2016-11-26T08:47:37
		System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));//2016-11-26T08:47:37
		System.out.println(DateFormatUtils.format(DateUtils.addDays(new Date(), 1), "yyyy-MM-dd HH:mm:ss"));//2016-11-26T08:47:37
	}
	
	/**
	 * 就是提供了支持返回多个元素的一些类
	 * Guava的Maps.immutableEntry 
	 * Map.Entry<String,Integer> entry2 = Maps.immutableEntry("rensanning.iteye.com", 9527); 
	 * MutableTriple对象是可以比较的
	 * 元组和列表list一样，都可能用于数据存储，包含多个数据；但是和列表不同的是：列表只能存储相同的数据类型，
	 * 而元组不一样，它可以存储不同的数据类型，比如同时存储int、string、list等，并且可以根据需求无限扩展。
	 * 当在一个方法中， 你需要返回几个对象，这几个对象的类型一致，你可以返回一个数组；如果几个对象的类型不同呢，当然你可以返回一个Object[]数组，可是这样在使用结果数组的时候，就需要强转对象的类型，会导致类型不安全；也可以定义一个dto，当多个场景下需要使用的不同，需要定义多个dto，这样会类爆炸，而且重用率极低；在非常接近Java语言的Scala里有元组的定义：val t = (1, 3.14, "Fred")，就是一个不同类型的数据放到一个线性集合里，在Java里我们可以模拟出一个类似的结构，以适合上面的场景
	 */
	public void testMuttableTriple(){
		MutablePair<String,Integer> monday = new MutablePair<String, Integer>("星期一",0);
		System.out.println(monday.getLeft());
		System.out.println(monday.getRight());
		MutableTriple<String, String, String> student = new MutableTriple<String, String, String>("婧哥哥","郭婧","郭大侠");
		System.out.println(student.getLeft());
	}
	
	/**
	 * 前置校验，校验失败报IllegalArgumentException异常
	 */
	public void testValidate(){
		int i = 1;
		Validate.isTrue(i > 0, "The value must be greater than zero: %d", i);
		Validate.isTrue(i < 0, "The value must be greater than zero: %d", i);
		Validate.notNull("hello", "The surname must not be %s", "null");
		Validate.notNull("", "The surname must not be %s", "null");
	}
	
}
