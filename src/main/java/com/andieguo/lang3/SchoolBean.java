package com.andieguo.lang3;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SchoolBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2618428079233870928L;

	private String name;
	
	private TeacherBean teacher;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeacherBean getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherBean teacher) {
		this.teacher = teacher;
	}

	public SchoolBean(String name, TeacherBean teacher) {
		super();
		this.name = name;
		this.teacher = teacher;
	}

	public SchoolBean() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	
	
}
