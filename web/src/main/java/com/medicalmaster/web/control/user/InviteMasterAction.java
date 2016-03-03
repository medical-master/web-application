package com.medicalmaster.web.control.user;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.Status;
import com.medicalmaster.common.user.CreateUserRequest;
import com.medicalmaster.web.control.WebContext;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class InviteMasterAction implements Processor {
	private WebTarget userResourceTarget;
	
	public InviteMasterAction() {
		Client client = ClientBuilder.newClient();
		userResourceTarget = client.target("http://localhost:9091").path("resource/users");
	}

	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext)ctx;
		Status s = post(context, CreateUserRequest.class, Status.class);
		context.setResult(s);;
		
	}

	private <T, K> K post(WebContext context, Class<T> req, Class<K> resp) {
		return userResourceTarget.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(populateForm(context, CreateUserRequest.class),
						MediaType.APPLICATION_FORM_URLENCODED_TYPE),
						resp);
	}
	
	private <T> Form populateForm(WebContext context, Class<T> clazz) {
		String[] formFields = getFields(CreateUserRequest.class);

		Form form = new Form();

		for (String field: formFields) {
			form.param(field, context.getRequest().getParameter(field));
		}
		return form;
	}

	private <T> String[] getFields(Class<T> clazz) {
		List<String> fList = new ArrayList<>();
		for (Field f : clazz.getDeclaredFields()) {
			FormParam param = f.getAnnotation(FormParam.class);
			if (param != null)
				fList.add(param.value());
		}
		return fList.toArray(new String[fList.size()]);
	}
}
