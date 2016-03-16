package com.medicalmaster.web.helper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.web.control.WebContext;

public class ResourceProxy {

	public static <T, K> K post(WebContext context, String url, Class<T> reqClazz, Class<K> respClazz) {
		WebTarget userResourceTarget = ClientBuilder.newClient().target(url);
		
		return userResourceTarget.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(populateForm(context, reqClazz),
						MediaType.APPLICATION_FORM_URLENCODED_TYPE),
						respClazz);
	}
	
	public static <T, K> K get(WebContext context, String url, Class<K> respClazz) {
		WebTarget userResourceTarget = ClientBuilder.newClient().target(url);
		
		return userResourceTarget.request(MediaType.APPLICATION_JSON_TYPE)
				.get(respClazz);
	}
	
	public static <T, K> K put(WebContext context, String url, Class<T> reqClazz, Class<K> respClazz) {
		WebTarget userResourceTarget = ClientBuilder.newClient().target(url);
		
		return userResourceTarget.request(MediaType.APPLICATION_JSON_TYPE)
				.put(Entity.entity(populateForm(context, reqClazz),
						MediaType.APPLICATION_FORM_URLENCODED_TYPE),
						respClazz);
	}
	
	public static <T, K> K delete(WebContext context, String url, Class<K> respClazz) {
		WebTarget userResourceTarget = ClientBuilder.newClient().target(url);
		
		return userResourceTarget.request(MediaType.APPLICATION_JSON_TYPE)
				.delete(respClazz);
	}
	
	private static <T> Form populateForm(WebContext context, Class<T> clazz) {
		String[] formFields = getFields(clazz);

		Form form = new Form();

		for (String field: formFields) {
			form.param(field, context.getRequest().getParameter(field));
		}
		return form;
	}

	private static <T> String[] getFields(Class<T> clazz) {
		List<String> fList = new ArrayList<>();
		for (Field f : clazz.getDeclaredFields()) {
			FormParam param = f.getAnnotation(FormParam.class);
			if (param != null)
				fList.add(param.value());
		}
		return fList.toArray(new String[fList.size()]);
	}

}
