package com.andieguo.lang3;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TeacherBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7109407035176922569L;
	private String name;
	
	public TeacherBean() {
		super();
	}

	public TeacherBean(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
