package com.medicalmaster.web.helper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.web.control.WebContext;

public class ResourceProxy {
	public static <T, K> K post(WebContext context, String url, T req, Class<K> respClazz) {
		WebTarget userResourceTarget = ClientBuilder.newClient().target(url);
		
		return userResourceTarget.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(req,
						MediaType.APPLICATION_FORM_URLENCODED_TYPE),
						respClazz);
	}

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
	
	public static <T, K> K get(WebContext context, String url, Class<T> reqClazz, Class<K> respClazz) {
		WebTarget userResourceTarget = populateQuery(context, url, reqClazz);
		
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
	
	private static <T> WebTarget buildTarget(WebContext context, String baseUrl, Class<T> clazz) {
		WebTarget userResourceTarget = ClientBuilder.newClient().target(baseUrl);
		
		String[] pathFields = getPathFields(clazz);
		
		for (String field: pathFields) {
			userResourceTarget = userResourceTarget.path(context.getRequest().getParameter(field));
		}
		
		return userResourceTarget;
	}
	
	private static <T> WebTarget populateQuery(WebContext context, String baseUrl, Class<T> reqestClazz) {
		WebTarget target = buildTarget(context, baseUrl, reqestClazz);

		String[] queryFields = getQueryFields(reqestClazz);

		for (String field: queryFields) {
			target = target.queryParam(field, context.getRequest().getParameter(field));
		}
		return target;
	}

	private static <T> Form populateForm(WebContext context, Class<T> reqestClazz) {
		String[] formFields = getFormFields(reqestClazz);

		Form form = new Form();

		for (String field: formFields) {
			form.param(field, context.getRequest().getParameter(field));
		}
		return form;
	}

	private static <T> String[] getFormFields(Class<T> reqestClazz) {
		List<String> fList = new ArrayList<>();
		for (Field f : reqestClazz.getDeclaredFields()) {
			FormParam param = f.getAnnotation(FormParam.class);
			if (param != null)
				fList.add(param.value());
		}
		return fList.toArray(new String[fList.size()]);
	}

	private static <T> String[] getQueryFields(Class<T> reqestClazz) {
		List<String> fList = new ArrayList<>();
		for (Field f : reqestClazz.getDeclaredFields()) {
			QueryParam param = f.getAnnotation(QueryParam.class);
			if (param != null)
				fList.add(param.value());
		}
		return fList.toArray(new String[fList.size()]);
	}

	/**
	 * PathParam must be declared in order in request class
	 * @param reqestClazz
	 * @return
	 */
	private static <T> String[] getPathFields(Class<T> reqestClazz) {
		List<String> fList = new ArrayList<>();
		for (Field f : reqestClazz.getDeclaredFields()) {
			PathParam param = f.getAnnotation(PathParam.class);
			if (param != null)
				fList.add(param.value());
		}
		return fList.toArray(new String[fList.size()]);
	}
}
