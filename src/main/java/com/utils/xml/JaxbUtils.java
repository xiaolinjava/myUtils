package com.utils.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbUtils {
	
	private JaxbUtils() {
		
	}
	
	public static String convertToXml(Object source) {
    	return convertToXml(source, source.getClass());
    }

    @SuppressWarnings("rawtypes")
	public static String convertToXml(Object source, Class type) {
        String result;
        StringWriter sw = new StringWriter();
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(type);
            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.marshal(source, sw);
            result = sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T convertToObject(String xml, Class<T> type) {
        StringReader sr = new StringReader(xml);
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

}
