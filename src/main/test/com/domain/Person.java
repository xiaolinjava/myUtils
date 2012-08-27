package com.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Person {

	private String id;

	private String batchId;

	private String name;

	private String age;

	private String sex;

	public Person() {
		super();
	}

	public Person(String id, String batchId, String name, String age, String sex) {
		this();
		this.id = id;
		this.batchId = batchId;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", batchId=" + batchId + ", name=" + name
				+ ", age=" + age + ", sex=" + sex + "]";
	}
	
	

}
