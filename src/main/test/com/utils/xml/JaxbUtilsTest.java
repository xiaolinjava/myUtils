package com.utils.xml;

import junit.framework.Assert;

import org.junit.Test;

import com.domain.NoXmlRootElementPerson;
import com.domain.Person;

public class JaxbUtilsTest {
	
	private static final String PERSON_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person><age>20</age><batchId>1</batchId><id>1</id><name>cilin.xiao</name><sex>男</sex></person>";

	@Test
	public void should_be_convert_to_Object_successful_when_given_xml_and_class_type() {
		Person person = JaxbUtils.convertToObject(PERSON_XML, Person.class);
		Assert.assertNotNull(person);
		Assert.assertEquals("1", person.getId());
		Assert.assertEquals("1", person.getBatchId());
		Assert.assertEquals("cilin.xiao", person.getName());
		Assert.assertEquals("20", person.getAge());
		Assert.assertEquals("男", person.getSex());
		
		System.out.println(person);
	}
	
	@Test	
	public void should_be_convert_to_Object_fail_when_given_no_xmlRootElement_sign_class_xml_and_type() {
		NoXmlRootElementPerson person = null;
		try {
			person = JaxbUtils.convertToObject(PERSON_XML, NoXmlRootElementPerson.class);
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertNull(person);
	}
	
	@Test
	public void should_be_convert_to_xml_successful_when_given_object_and_class_type() {
		Person person = new Person("1", "1", "cilin.xiao", "20", "男");
		String personXml = JaxbUtils.convertToXml(person, Person.class);
		Assert.assertNotNull(personXml);
		Assert.assertEquals(PERSON_XML, personXml);
		
		System.out.println(personXml);
	}
	
	@Test
	public void should_be_convert_to_xml_fail_when_given_no_xmlRootElement_sign_object_and_class_type() {
		NoXmlRootElementPerson person = new NoXmlRootElementPerson("1", "1", "cilin.xiao", "20", "男");
		String personXml = null;
		try {
			personXml = JaxbUtils.convertToXml(person, NoXmlRootElementPerson.class);
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertNull(personXml);
		
	}
	
	@Test
	public void should_be_convert_to_xml_successful_when_given_object() {
		Person person = new Person("1", "1", "cilin.xiao", "20", "男");
		String personXml = JaxbUtils.convertToXml(person);
		Assert.assertNotNull(personXml);
		Assert.assertEquals(PERSON_XML, personXml);
		
		System.out.println(personXml);
	}
	
	@Test
	public void should_be_convert_to_xml_fail_when_given_no_xmlRootElement_sign_class_object() {
		NoXmlRootElementPerson person = new NoXmlRootElementPerson("1", "1", "cilin.xiao", "20", "男");
		String personXml = null;
		try {
			personXml = JaxbUtils.convertToXml(person);			
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertNull(personXml);
		
	}
}
