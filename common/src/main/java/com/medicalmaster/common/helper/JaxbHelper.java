package com.medicalmaster.common.helper;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * JAXB 工具类
 * 
 * @author Administrator
 * 
 */
public class JaxbHelper {

	/**
	 * XML转成POJO
	 * 
	 * @param class1
	 *            类
	 * @param xml
	 *            XML参数
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2Pojo(Class<T> class1, String xml)
			throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(class1);

		Unmarshaller um = jaxbContext.createUnmarshaller();
		ByteArrayInputStream is = null;
		try {
			try{
				is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
			}catch(Exception e){
				e.printStackTrace();
			}
			return (T) um.unmarshal(is);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
			}
		}

	}
}
